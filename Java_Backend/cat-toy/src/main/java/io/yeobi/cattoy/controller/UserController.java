package io.yeobi.cattoy.controller;

import com.github.dozermapper.core.Mapper;
import io.yeobi.cattoy.domain.User;
import io.yeobi.cattoy.dto.UserDto;
import io.yeobi.cattoy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    @PostMapping
    public ResponseEntity<?> signUp(
            @RequestBody UserDto userDto
    ) throws URISyntaxException {
        User user = mapper.map(userDto, User.class);

        userService.register(user);

        URI location = new URI("/");

        return ResponseEntity.created(location).build();
    }

}
