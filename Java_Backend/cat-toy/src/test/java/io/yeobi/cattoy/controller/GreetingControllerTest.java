package io.yeobi.cattoy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
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

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));  // Response의 content에 "Hello" 포함되어 있는지 테스트
    }

}