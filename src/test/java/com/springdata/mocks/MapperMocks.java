package com.springdata.mocks;

import com.springdata.dto.UserDto;
import com.springdata.mapper.UserDtoMapper;
import com.springdata.stubs.TestStubs;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class MapperMocks {

    public void initMocks(UserDtoMapper userDtoMapper){
        when(userDtoMapper.toUser(any(UserDto.class))).thenReturn(TestStubs.generateUser());
    }

}
