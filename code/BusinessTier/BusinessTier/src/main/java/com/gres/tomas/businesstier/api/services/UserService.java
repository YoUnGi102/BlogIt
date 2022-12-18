package com.gres.tomas.businesstier.api.services;

import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import com.gres.tomas.businesstier.api.exceptions.EntityAlreadyExistsException;
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
    public User postUser(CreateUserDto dto) throws InvalidAttributeException, EntityAlreadyExistsException {

        ValidateCreateUser(dto);

        User user = new User(
          dto.getUsername(),
          dto.getPassword(),
          dto.getEmail()
        );
        return userRepository.save(user);
    }

    private void ValidateCreateUser(CreateUserDto dto) throws EntityAlreadyExistsException, InvalidAttributeException {
        if(dto.getEmail() != null && userRepository.findByEmailIs(dto.getEmail()) != null){
            throw new EntityAlreadyExistsException("User with this e-mail already exists");
        }
        if(dto.getUsername() != null && userRepository.findByUsername(dto.getUsername()) != null){
            throw new EntityAlreadyExistsException("User with this username already exists");
        }
        if(dto.getPassword() != null && dto.getPassword().length() < 6){
            throw new InvalidAttributeException("Password has to be at least 6 characters long");
        }
    }
}
