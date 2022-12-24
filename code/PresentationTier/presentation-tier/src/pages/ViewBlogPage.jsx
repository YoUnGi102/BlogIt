import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {EMPTY_BLOG} from "../domain/model/Blog"
import {serverPath} from "../config";

export default function ViewBlogPage(props){

    const {blogId} = useParams();

    const [blog, setBlog] = useState(EMPTY_BLOG);

    useEffect(() => {
        const apiURL = serverPath + "blogs" + "/" + blogId;
        fetch(apiURL)
            .then((response) => {
                if(response.ok){
                    return response.json()
                }else{
                    console.log(response.text())
                }
            })
            .then((data) => {
               setBlog(data);
            });
    })

    return (
        <div>
            <h1>{blog.name}</h1>
            <h1>{blog.description}</h1>
        </div>
    )

}