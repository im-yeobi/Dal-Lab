package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeobi
 * @created 2019-10-23
 */
@RestController // REST API
public class GreetingController {

    @GetMapping("/hello") // Get 메소드 형식의 요청 받는다.
    public Greeting hello() {
        Greeting greeting = new Greeting();
        greeting.setName("yeobi");
        greeting.setMessage("Hello, world");

        // JSON return { "name": "yeobi", "message": "Hello, world" }
        return greeting;
    }

}
