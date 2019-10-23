package io.yeobi.cattoy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeobi
 * @created 2019-10-23
 */
@RestController // REST API
public class GreetingController {

    @GetMapping("/hello") // Get 메소드 형식의 요청 받는다.
    public String hello() {
        return "Hello, World";
    }

}
