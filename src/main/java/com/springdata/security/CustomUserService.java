package com.springdata.security;

import com.springdata.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserService extends UserDetailsService {
    User loadUserByUsername(String username);
}
