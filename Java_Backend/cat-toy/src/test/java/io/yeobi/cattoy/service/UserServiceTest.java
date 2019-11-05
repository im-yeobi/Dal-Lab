package io.yeobi.cattoy.service;

import io.yeobi.cattoy.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * @author yeobi
 * @created 2019-11-05
 */
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Mock
        userService = new UserService(userRepository);
    }

    @Test
    public void register() {
        User user = User.builder()
                .name("테스터")
                .email("tester@example.com")
                .password("pwd")
                .build();

        userService.register(user);

        verify(userRepository).save(user);  // any(User.class)와 차이는 ?
    }

}