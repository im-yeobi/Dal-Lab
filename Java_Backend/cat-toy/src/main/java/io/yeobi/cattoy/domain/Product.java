package io.yeobi.cattoy.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;    // javax : java 표준에서의 확장
import javax.persistence.Id;
import java.text.NumberFormat;
import java.util.Objects;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Entity // JPA에서 잡아주는 것이다
@Builder
public class Product {

    @Id
    private Long id;

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
