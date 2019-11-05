package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.domain.User;
import io.yeobi.cattoy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yeobi
 * @created 2019-11-05
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    /**
     * User 생성 테스트
     */
    @Test
    public void singUp() throws Exception {

        mockMvc.perform(
                post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"테스터\"," +
                        "\"email\":\"tester@example.com\"," +
                        "\"password\":\"pwd\"}")
        )
                .andExpect(status().isCreated());

        verify(userService).register(any(User.class));
    }

}