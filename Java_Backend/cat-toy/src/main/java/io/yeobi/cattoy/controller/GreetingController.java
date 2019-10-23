package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.dto.GreetingDto;
import io.yeobi.cattoy.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeobi
 * @created 2019-10-23
 */
@RestController // REST API
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/hello") // Get 메소드 형식의 요청 받는다.
    public GreetingDto hello(
            @RequestParam(required = false) String name
    ) {
        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setName("yeobi");
        greetingDto.setMessage(greetingService.getMessage(name));

        return greetingDto;
    }

}
