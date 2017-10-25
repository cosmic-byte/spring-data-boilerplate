package com.springdata.service;

import com.springdata.dto.UserDto;
import com.springdata.enums.RoleType;
import com.springdata.model.User;


public interface UserService {

    User saveUser(UserDto userDto, RoleType roleType);
}
