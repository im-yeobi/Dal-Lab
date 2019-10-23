package io.yeobi.cattoy.domain;

import lombok.Builder;
import lombok.Getter;

import java.text.NumberFormat;
import java.util.Objects;

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

    private String imageUrl;

    public String getPriceWithComma() {
        return NumberFormat.getInstance().format(price);
    }

    public String getImageUrl() {
        return Objects.isNull(imageUrl) ? "" : imageUrl;
    }

    public void changeImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
