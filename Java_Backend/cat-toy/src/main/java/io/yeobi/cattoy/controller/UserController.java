package io.yeobi.cattoy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author yeobi
 * @created 2019-11-05
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<?> signUp() throws URISyntaxException {
        URI location = new URI("/");

        return ResponseEntity.created(location).build();
    }

}
