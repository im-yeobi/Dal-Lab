package io.yeobi.cattoy.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-10-24
 * @description 상품 도메인에 대한 테스트
 */
public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = Product.builder()
                .name("쥐돌이")
                .maker("펭귄")
                .price(3000)
                .build();
    }

    /**
     * 상품 생성 테스트
     */
    @Test
    public void create() {
        assertThat(product.getName()).isEqualTo("쥐돌이");
        assertThat(product.getMaker()).isEqualTo("펭귄");
        assertThat(product.getPriceWithComma()).isEqualTo("3,000");
    }

    /**
     * 기본 이미지 테스트
     */
    @Test
    public void defaultImage() {
        assertThat(product.getImageUrl()).isEqualTo("");
    }

    /**
     * 이미지 있는 경우 테스트
     */
    @Test
    public void changeImage() {
        final String imageUrl = "https://change";
        product.changeImage(imageUrl);

        assertThat(product.getImageUrl()).isEqualTo("https://change");
    }

}
