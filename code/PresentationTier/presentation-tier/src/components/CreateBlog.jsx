import React, {useState} from "react";
import {Button, TextField, FormControl, FormGroup, MenuItem} from '@mui/material';
import "./CreateBlog.css"
import CreateBlogDto from "../domain/dto/CreateBlogDto"

function CreateBlog(){

    //const controller = new BlogHttpController();

    const initDto : CreateBlogDto = {
        name:"",
        description:"",
        access:"",
        authorId: 1
    }
    const [dto, setDto] = useState(initDto);

    const [error, setError] = useState({
        name: "",
        description: "",
        access: ""
    })

    // const [id, setId] = useState(0);


    const handleTextFieldChange = (
        event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
    ) => {
        const { name, value } = event.target;
        setDto({
            ...dto,
            [name]: value,
        });
    };

    async function handleSubmit() {
        const url = 'http://localhost:8080/api/v1/blogs';

        fetch(url, {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dto),
        }).then(response => {
                if(response.ok){
                    response.json()
                       // .then(data => setId(data.id))
                }else{
                    response.json()
                        .then(res => {validateFields(res)});
                }
            }
        );

    }

    function validateFields(errorText){
        console.log(errorText.message);
        const errorMessages = JSON.parse(errorText.message)
        console.log(errorMessages)
        console.log(errorMessages.name);
        console.log(errorMessages.description);
        console.log(errorMessages.access);
        setError({
            name: (errorMessages.name == null) ? "" : errorMessages.name,
            description: (errorMessages.description == null) ? "" : errorMessages.description,
            access: (errorMessages.access == null) ? "" : errorMessages.access,
        });
        console.log(error);
    }

    return(
        <div className="CreateBlog">
            <h1>Create a New Blog</h1>
            <form>
                <FormGroup>
                    <FormControl
                        component="form"
                        validate
                        autoComplete="off"
                    >
                        <TextField
                            error={error.name.length > 0}
                            helperText={error.name}
                            className="TextField"
                            id="name"
                            name="name"
                            label=" Blog name"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            autoFocus
                            required
                        />
                        <TextField
                            error={error.description.length > 0}
                            helperText={error.description}
                            className="TextField"
                            id="description"
                            name="description"
                            label=" Description"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            multiline
                            required
                            maxRows={4}
                        />
                        <TextField
                            error={error.access.length > 0}
                            helperText={error.access}
                            className="TextField"
                            id="access"
                            name="access"
                            label=" Access"
                            variant="outlined"
                            onChange={handleTextFieldChange}
                            select
                            required
                        >
                            <MenuItem value={"private"}>Private</MenuItem>
                            <MenuItem value={"restricted"}>Followers only</MenuItem>
                            <MenuItem value={"public"}>Public</MenuItem>
                        </TextField>
                        <Button
                            className="Button"
                            type="submit"
                            variant="outlined"
                            color="success"
                            onClick={handleSubmit}
                        >Submit</Button>
                    </FormControl>
                </FormGroup>
            </form>

        </div>

    );
}

export default CreateBlog;