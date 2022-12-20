import React from "react";
import Fab from "@mui/material/Fab";
import AddIcon from "@mui/icons-material/Add";
import {useNavigate} from "react-router-dom";

function ActionButton(props){

    console.log("Activated")
    let navigate = useNavigate();
    const routeChange = () => {
        let path = props.path;
        console.log(path);
        navigate(path);
    }

    return (
        <div className="add-button">
            <Fab onClick={routeChange} color="primary" aria-label="add">
                <AddIcon/>
            </Fab>
        </div>
    );
}

export default ActionButton;