package com.gres.tomas.businesstier.api.serviceInterfaces;

import com.gres.tomas.businesstier.domain.dto.CreateUserDto;
import com.gres.tomas.businesstier.domain.model.User;

public interface IUserService {

    User postUser(CreateUserDto dto);

}
