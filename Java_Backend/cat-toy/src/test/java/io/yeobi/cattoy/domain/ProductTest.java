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
        Product product = new Product();
        product.setName("쥐돌이");

        assertThat(product.getName()).isEqualTo("쥐돌이");
    }

}
