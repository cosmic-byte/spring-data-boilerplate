package com.springdata.mocks;

import com.springdata.repository.UserRepository;
import com.springdata.stubs.TestStubs;
import com.springdata.model.User;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class UserMocks {
    public void initMocks(UserRepository userRepository){
        when(userRepository.saveAndFlush(any(User.class))).thenReturn(TestStubs.generateUser());
    }
}
