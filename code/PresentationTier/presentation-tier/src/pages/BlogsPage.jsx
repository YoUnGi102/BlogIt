import React from "react";
import Blog from '../components/Blog';
import "./BlogsPage.css";
import ActionButton from "../components/ActionButton"

function BlogsPage(){

    console.log("/")

    return(
        <div>
            <Blog title={"Mechanics"}
                  description={"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum..."}
                  posts={0} likes={0} dislikes={0} comments={0} lastUpdate={"2022/12/01 08:00"}
            />
            <Blog title={"Mechanics"}
                  description={"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum..."}
                  posts={0} likes={0} dislikes={0} comments={0} lastUpdate={"2022/12/01 08:00"}
            />
            <ActionButton path={"/blogs/create"}/>
        </div>
    );
}

export default BlogsPage;
