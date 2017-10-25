package com.springdata.mocks;

import com.springdata.repository.RoleRepository;
import com.springdata.stubs.TestStubs;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class RoleMocks {

    public void initMocks(RoleRepository roleRepository){
        when(roleRepository.findByName(anyString())).thenReturn(TestStubs.generateOptionalRole());
    }
}
