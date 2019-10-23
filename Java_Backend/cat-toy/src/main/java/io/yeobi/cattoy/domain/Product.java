package io.yeobi.cattoy.domain;

import lombok.Builder;
import lombok.Getter;

import java.text.NumberFormat;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Builder
public class Product {

    @Getter
    private String name;

    @Getter
    private String maker;

    @Getter
    private Integer price;

    public String getPriceWithComma() {
        return NumberFormat.getInstance().format(price);
    }


}
