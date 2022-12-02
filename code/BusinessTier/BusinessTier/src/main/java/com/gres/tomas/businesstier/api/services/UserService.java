package com.gres.tomas.businesstier.api.services;

import com.gres.tomas.businesstier.api.serviceInterfaces.IUserService;
import com.gres.tomas.businesstier.domain.dto.CreateUserDto;
import com.gres.tomas.businesstier.domain.model.User;
import com.gres.tomas.businesstier.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User postUser(CreateUserDto dto) {
        User user = new User(
          dto.getUsername(),
          dto.getPassword(),
          dto.getEmail()
        );
        return userRepository.save(user);
    }

}
