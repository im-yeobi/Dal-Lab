package io.yeobi.cattoy.domain;

import io.yeobi.cattoy.dto.ProductDto;
import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment. 해당 엔티티에 대해서만 인덱스를 준다.
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String maker;

    @Getter
    private Integer price;

    private String imageUrl;

    @Transient  // DB 생략 어노테이션, 임시 변수일 때 종종 사용한다
    private Boolean deleted;

    public String getPriceWithComma() {
        return NumberFormat.getInstance().format(price);
    }

    public String getImageUrl() {
        return Objects.isNull(imageUrl) ? "" : imageUrl;
    }

    public void changeImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void changeWithDto(ProductDto productDto) {  // 도메인에 DTO를 전달받았다.
        name = productDto.getName();
        maker = productDto.getMaker();
        price = productDto.getPrice();
    }

}
