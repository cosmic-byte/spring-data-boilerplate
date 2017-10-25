package com.springdata.service;

import com.springdata.model.Role;
import com.springdata.dto.UserDto;
import com.springdata.enums.RoleType;
import com.springdata.mapper.UserDtoMapper;
import com.springdata.model.User;
import com.springdata.repository.RoleRepository;
import com.springdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserDtoMapper userDtoMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, UserDtoMapper userDtoMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User saveUser(UserDto userDto, RoleType roleType) {
        User user = userDtoMapper.toUser(userDto);
        encodeAndSetUserPassword(user);
        return setUserRole(user, roleType);
    }

    private void encodeAndSetUserPassword(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword().trim()));
    }

    private User setUserRole(User user, RoleType roleType){
        Optional<Role> optionalRole = roleRepository.findByName(roleType.name());
        optionalRole.ifPresent(user::setRole);
        return userRepository.saveAndFlush(user);
    }
}
