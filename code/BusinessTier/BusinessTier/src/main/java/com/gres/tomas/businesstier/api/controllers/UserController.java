package com.gres.tomas.businesstier.api.controllers;

import com.gres.tomas.businesstier.api.serviceInterfaces.IUserService;
import com.gres.tomas.businesstier.domain.dto.CreateUserDto;
import com.gres.tomas.businesstier.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping
    public User postUser(@RequestBody CreateUserDto dto) throws Throwable {
        return service.postUser(dto);
    }
}
