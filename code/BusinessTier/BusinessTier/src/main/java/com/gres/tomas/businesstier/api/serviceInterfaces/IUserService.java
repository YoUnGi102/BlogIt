package com.gres.tomas.businesstier.api.serviceInterfaces;

import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import com.gres.tomas.businesstier.api.exceptions.EntityAlreadyExistsException;
import com.gres.tomas.businesstier.domain.dto.CreateUserDto;
import com.gres.tomas.businesstier.domain.model.User;

public interface IUserService {

    User postUser(CreateUserDto dto) throws Throwable;

}
