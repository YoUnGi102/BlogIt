import React, {useState} from "react";
import {Button, TextField, FormControl, FormGroup, MenuItem} from '@mui/material';
import "./CreateBlog.css"
import CreateBlogDto from "../domain/dto/CreateBlogDto"
import Blog from "../domain/model/Blog";
//import {BlogHttpController} from "../httpClients/BlogHttpController"

function CreateBlog(){

    //const controller = new BlogHttpController();

    var initDto : CreateBlogDto = {
        name:"Mechanical Engineering",
        description:"Mechanics and stuff for readers of every age and knowledge level",
        access:"private",
        authorId: 1
    }

    const [dto, setDto] = useState(initDto);

    const [id, setId] = useState(0);


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
        }).then(response => response.json())
        .then(data => setId(data.id));
    }

    return(
        <div>
            <h1>Create a New Blog</h1>
            <form>
                <FormGroup>
                    <FormControl
                        className={"CreateBlog"}
                        component="form"
                        validate
                        autoComplete="off"
                    >
                        <TextField
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