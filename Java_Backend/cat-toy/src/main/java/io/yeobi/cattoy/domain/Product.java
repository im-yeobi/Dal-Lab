package io.yeobi.cattoy.domain;

import lombok.Builder;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Builder
public class Product {

    private String name;

    public String getName() {
        return name;
    }

}
