package io.yeobi.cattoy.service;

import io.yeobi.cattoy.controller.ProductService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-10-24
 */
public class ProductServiceTest {

    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void getProducts() {
        assertThat(productService.getProducts()).isEmpty();
    }

    @Test
    public void add() {
        productService.addProduct("쥐돌이");

        assertThat(productService.getProducts()).isNotEmpty();
    }

}
