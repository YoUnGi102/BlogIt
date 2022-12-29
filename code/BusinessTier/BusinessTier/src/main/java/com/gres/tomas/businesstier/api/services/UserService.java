package com.gres.tomas.businesstier.api.services;

import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import com.gres.tomas.businesstier.api.exceptions.EntityAlreadyExistsException;
import com.gres.tomas.businesstier.api.serviceInterfaces.IUserService;
import com.gres.tomas.businesstier.domain.dto.CreateUserDto;
import com.gres.tomas.businesstier.domain.helper.ValidationError;
import com.gres.tomas.businesstier.domain.model.User;
import com.gres.tomas.businesstier.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User postUser(CreateUserDto dto) throws Throwable {

        ValidateCreateUser(dto);

        User user = new User(
          dto.getUsername(),
          dto.getPassword(),
          dto.getEmail()
        );
        return userRepository.save(user);
    }

    private void ValidateCreateUser(CreateUserDto dto) throws Throwable {
        ValidationError error = new ValidationError();

        System.out.println(userRepository.findByEmailIs(dto.getEmail()));
        System.out.println(userRepository.findByUsername(dto.getUsername()));

        if(dto.getEmail() != null && userRepository.findByEmailIs(dto.getEmail()) != null){
            error.addError("email", "User with this e-mail already exists", HttpStatus.CONFLICT);
        }
        if(dto.getUsername() != null && userRepository.findByUsername(dto.getUsername()) != null){
            error.addError("username", "User with this username already exists", HttpStatus.CONFLICT);
        }
        if(dto.getPassword() != null && dto.getPassword().length() < 6){
            error.addError("password", "Password has to be at least 6 characters long", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(dto.getUsername() != null && dto.getUsername().length() < 6){
            error.addError("username", "Username has to be at least 6 characters long", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(error.hasErrors()){
            error.throwFirstException();
        }

    }

    private void ValidateEmail(String email){
        // TODO VALIDATION OF EMAIl
        // https://help.returnpath.com/hc/en-us/articles/220560587-What-are-the-rules-for-email-address-syntax-

        int nameCharCount = 0;
        for (char c : email.toCharArray()) {
//            if(c == '@' && nameCharCount < ){
//
//            }
            if(isCharacterAllowed(c, nameCharCount == 0) && nameCharCount <= 64){
                nameCharCount++;
            }else {
                throw new InvalidAttributeException("Email format is not correct");
            }

        }
    }

    private boolean isCharacterAllowed(char c, boolean isFirst){
        if (isFirst && "!#$%&'*+-/=?^_`{|.".contains(String.valueOf(c)))
            return false;
        return "!#$%&'*+-/=?^_`{|.".contains(String.valueOf(c)) || !isFirst && "!#$%&'*+-/=?^_`{|.".contains(String.valueOf(c))
                || c > 'A' && c < 'Z' || c > 'a' && c < 'z' || c > '0' && c < '9';
    }
}
