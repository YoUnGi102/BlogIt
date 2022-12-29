package com.gres.tomas.businesstier.api.controllers;

import com.gres.tomas.businesstier.api.serviceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    IUserService userService;

//    @Autowired
//    PasswordEncoder encoder;

    @PostMapping("/signin")
    public void signIn(){

    }

    @PostMapping("/signup")
    public void signUp(){

    }

}
