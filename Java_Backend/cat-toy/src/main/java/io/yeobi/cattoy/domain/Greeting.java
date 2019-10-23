package io.yeobi.cattoy.domain;

import lombok.Builder;

import java.util.Objects;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Builder
public class Greeting {

    private String name;

    public String getMessage() {
        if (Objects.isNull(name)) {
            return "Hello";
        }
        return "Hello, " + name;
    }
}
