package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeobi
 * @created 2019-10-23
 */
@RestController // REST API
public class GreetingController {

    @GetMapping("/hello") // Get 메소드 형식의 요청 받는다.
    public Greeting hello(
            @RequestParam(defaultValue = "world") String name
    ) {
        Greeting greeting = new Greeting();
        greeting.setName("yeobi");
        greeting.setMessage("Hello, " + name);

        return greeting;
    }

}
