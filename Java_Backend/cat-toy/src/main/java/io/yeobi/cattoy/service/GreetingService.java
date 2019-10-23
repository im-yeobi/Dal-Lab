package io.yeobi.cattoy.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Service    // @Component를 사용할 수도 있지만 애플리케이션 레이어에서 용도를 명시해주기 위해 @Service 어노테이션 사용
public class GreetingService {

    public String getMessage(String name) {
        return Objects.isNull(name) ? "Hello" : name;
    }

}
