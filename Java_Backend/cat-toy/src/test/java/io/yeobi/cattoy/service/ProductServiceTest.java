package io.yeobi.cattoy.service;

import io.yeobi.cattoy.controller.ProductService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-10-24
 */
public class ProductServiceTest {

    @Test
    public void getProducts() {
        ProductService productService = new ProductService();

        assertThat(productService.getProducts()).isEmpty();
    }

}
