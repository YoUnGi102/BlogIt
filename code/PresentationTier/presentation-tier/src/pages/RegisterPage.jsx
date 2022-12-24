import "./RegisterPage.css";
import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import {Button, FormControl, FormGroup, MenuItem, TextField} from "@mui/material";
import {serverPath} from "../config";
import {EMPTY_CREATE_USER_DTO} from "../domain/dto/CreateUserDto"

export default function RegisterPage(){

    const navigate = useNavigate();

    const [dto, setDto] = useState(EMPTY_CREATE_USER_DTO)
    const [error, setError] = useState(EMPTY_CREATE_USER_DTO);

    const handleTextFieldChange = (
        event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
    ) => {
        const { name, value } = event.target;
        setDto({
            ...dto,
            [name]: value,
        });
    };

    async function handleSubmit(event) {
        event.preventDefault();
        const url = serverPath + 'users';

        fetch(url, {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dto),
        }).then(response => {
                if(response.ok){
                    response.json()
                        .then(data => {
                            navigate("/blogs");
                        })
                }else{
                    response.json()
                        .then(res => {
                            validateFields(JSON.parse(res.message))});
                }
            }
        );

    }

    function validateFields(errorMessages){
        setError({
            username: (errorMessages.username == null) ? "" : errorMessages.username,
            email: (errorMessages.email == null) ? "" : errorMessages.email,
            password: (errorMessages.password == null) ? "" : errorMessages.password,
            repeatPassword: (errorMessages.repeatPassword == null) ? "" : errorMessages.repeatPassword
        });
        console.log(error);
    }

    return(
        <div className={"RegisterPage"}>
            <form>
                <FormGroup>
                    <FormControl
                        component="form"
                        validate
                        autoComplete="off"
                    >
                        <TextField
                            error={error.username.length > 0}
                            helperText={error.username}
                            className="TextField"
                            id="username"
                            name="username"
                            label=" Username"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            autoFocus
                            required
                        />
                        <TextField
                            error={error.email.length > 0}
                            helperText={error.email}
                            className="TextField"
                            id="email"
                            name="email"
                            label=" E-mail"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            multiline
                            required
                            maxRows={4}
                        />
                        <TextField
                            error={error.password.length > 0}
                            helperText={error.password}
                            className="TextField"
                            id="password"
                            name="password"
                            label=" Password"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            multiline
                            required
                            maxRows={4}
                        />
                        <TextField
                            error={error.repeatPassword.length > 0}
                            helperText={error.repeatPassword}
                            className="TextField"
                            id="repeatPassword"
                            name="repeatPassword"
                            label=" Repeat Password"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            multiline
                            required
                            maxRows={4}
                        />
                        <Button
                            className="Button"
                            type="submit"
                            variant="outlined"
                            color="success"
                            onClick={handleSubmit}
                        >Register</Button>
                    </FormControl>
                </FormGroup>
            </form>
        </div>
    )

}