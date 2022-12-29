package com.gres.tomas.businesstier.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/all")
    public void getAll(){

    }

    @GetMapping("/user")
    public void getUser(){

    }

}
