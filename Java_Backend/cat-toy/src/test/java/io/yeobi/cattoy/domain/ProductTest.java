package io.yeobi.cattoy.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-10-24
 * @description 상품 도메인에 대한 테스트
 */
public class ProductTest {

    /**
     * 상품 생성 테스트
     */
    @Test
    public void create() {
        Product product = Product.builder()
                .name("쥐돌이")
                .maker("펭귄")
                .price(3000)
                .build();

        assertThat(product.getName()).isEqualTo("쥐돌이");
        assertThat(product.getMaker()).isEqualTo("펭귄");
        assertThat(product.getPriceWithComma()).isEqualTo("3,000");
    }

    /**
     * 기본 이미지 테스트
     */
    @Test
    public void defaultImage() {
        Product product = Product.builder()
                .name("쥐돌이")
                .maker("펭귄")
                .price(3000)
                .build();

        assertThat(product.getImageUrl()).isEqualTo("");
    }

    /**
     * 이미지 있는 경우 테스트
     */
    @Test
    public void changeImage() {
        Product product = Product.builder()
                .name("쥐돌이")
                .maker("펭귄")
                .price(3000)
                .imageUrl("https://original")
                .build();

        product.changeImage("https://change");

        assertThat(product.getImageUrl()).isEqualTo("https://change");
    }

}
