package io.yeobi.cattoy.service;

import io.yeobi.cattoy.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author yeobi
 * @created 2019-11-05
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }

}
