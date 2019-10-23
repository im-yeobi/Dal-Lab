package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.service.GreetingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yeobi
 * @created 2019-10-24
 * @description Greeting 컨트롤러 테스트
 */
@RunWith(SpringRunner.class)    // 스프링러너로 테스트 실행
@WebMvcTest(GreetingController.class)   // 웹 MVC 테스트. Spring Framework에 의존적인 테스트
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;    // MVC를 테스트 하기 위한 가짜 객체이다.

    // 실제 가짜 객체(껍데기). Spy 객체는 실존하는 객체이나 제어가 용이하도록 침투하는 객체이다.
    @MockBean
    private GreetingService greetingService;

    @Before
    public void mockGreetingService() {
        // Given
        given(greetingService.getMessage(null)).willReturn("Hello");

        given(greetingService.getMessage("yeobi")).willReturn("yeobi");
    }

    @Test
    public void hello() throws Exception {
        // When
        ResultActions result = mockMvc.perform(
                get("/hello")
        );

        // Then
        result.andExpect(
                status().isOk()
        )
                .andExpect(
                        content().string(
                                containsString("Hello")
                        )
                );  // Response의 content에 "Hello" 포함되어 있는지 테스트

        verify(greetingService).getMessage(null);   // Given 사용되었는지 확인
    }

    @Test
    public void helloWithName() throws Exception {
        // When
        ResultActions result = mockMvc.perform(
                get(
                        "/hello"
                )
                        .param("name", "yeobi")
        );

        // Then
        result.andExpect(
                status().isOk()
        )
                .andExpect(
                        content().string(
                                containsString("yeobi")
                        )
                );

        verify(greetingService).getMessage("yeobi");
    }

}