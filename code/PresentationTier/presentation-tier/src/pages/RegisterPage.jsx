import "./RegisterPage.css";
import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import {
    Button, FormControl, FormGroup, TextField,
    OutlinedInput, IconButton, InputAdornment, InputLabel, FormHelperText
} from "@mui/material";
import {serverPath} from "../config";
import {EMPTY_CREATE_USER_DTO} from "../domain/dto/CreateUserDto"
import {Visibility, VisibilityOff} from '@mui/icons-material';

export default function RegisterPage(){

    const navigate = useNavigate();

    const [dto, setDto] = useState(EMPTY_CREATE_USER_DTO)
    const [error, setError] = useState(EMPTY_CREATE_USER_DTO);
    const [showPassword, setShowPassword] = useState(false);

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
            password: (errorMessages.password == null) ? "" : errorMessages.password
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
                            className="FormComponent"
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
                            className="FormComponent"
                            id="email"
                            name="email"
                            label=" E-mail"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            multiline
                            required
                            maxRows={4}
                        />
                        <FormControl
                            className={"FormComponent"}
                        >
                            <InputLabel htmlFor='outlined-adornment-password'>Password</InputLabel>
                            <OutlinedInput
                                helperText={error.password}
                                type={showPassword ? 'text' : 'password'}
                                label={" Password"}
                                name={"password"}
                                onChange={handleTextFieldChange}
                                required
                                endAdornment={
                                    <InputAdornment position="end">
                                        <IconButton
                                            aria-label="toggle password visibility"
                                            onClick={() => setShowPassword(!showPassword)}
                                            edge="end"
                                        >
                                            {showPassword ? <VisibilityOff /> : <Visibility />}
                                        </IconButton>
                                    </InputAdornment>
                                }
                            />
                            {!!error.password.length > 0 && (
                                <FormHelperText error id="password-error">
                                    {error.password}
                                </FormHelperText>
                            )}
                        </FormControl>
                        <Button
                            className="Button FormComponent"
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