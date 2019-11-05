package io.yeobi.cattoy.service;

import io.yeobi.cattoy.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * @author yeobi
 * @created 2019-11-05
 */
public class UserServiceTest {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Mock

        passwordEncoder = new BCryptPasswordEncoder();

        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    public void register() {
        User user = User.builder()
                .name("테스터")
                .email("tester@example.com")
                .password("pwd")    // 패스워드에 대한 암호화가 필요하다
                .build();

        given(userRepository.save(any())).willReturn(user);

        User createdUser = userService.register(user);

        assertThat(createdUser.getPassword()).isNotEqualTo("pwd");

        verify(userRepository).save(user);  // any(User.class)와 차이는 ?
    }

}