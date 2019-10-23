package io.yeobi.cattoy.service;

import java.util.Objects;

/**
 * @author yeobi
 * @created 2019-10-24
 */
public class GreetingService {

    public String getMessage(String name) {
        return Objects.isNull(name) ? null : name;
    }

}
