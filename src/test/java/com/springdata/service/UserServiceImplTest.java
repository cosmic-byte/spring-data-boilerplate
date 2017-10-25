package com.springdata.service;

import com.springdata.mocks.EnvironmentMocks;
import com.springdata.mocks.MapperMocks;
import com.springdata.dto.UserDto;
import com.springdata.enums.RoleType;
import com.springdata.mapper.UserDtoMapper;
import com.springdata.mocks.RoleMocks;
import com.springdata.mocks.UserMocks;
import com.springdata.model.User;
import com.springdata.repository.RoleRepository;
import com.springdata.repository.UserRepository;
import com.springdata.stubs.TestStubs;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    //dependencies
    @MockBean
    private Environment environment;
    @MockBean
    private RoleRepository roleRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserDtoMapper userDtoMapper;
    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //system under test.
    private UserService userService;

    //Mocks.
    private MapperMocks mapperMocks = new MapperMocks();
    private RoleMocks roleMocks = new RoleMocks();
    private UserMocks userMocks = new UserMocks();
    private EnvironmentMocks environmentMocks = new EnvironmentMocks();

    @Before
    public void setUp() throws Exception {
        mapperMocks.initMocks(userDtoMapper);
        environmentMocks.initMocks(environment);
        roleMocks.initMocks(roleRepository);
        userMocks.initMocks(userRepository);
        userService = new UserServiceImpl(roleRepository, userRepository, userDtoMapper,bCryptPasswordEncoder);
    }

    @Test
    public void saveUserShouldSave() throws Exception {
        UserDto userDto = TestStubs.generateUserDto();
        User user = userService.saveUser(userDto, RoleType.USER);

        assertThat(user).isNotNull();
    }

}