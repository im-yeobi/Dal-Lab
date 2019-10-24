package io.yeobi.cattoy.service;

import io.yeobi.cattoy.Repository.ProductRepository;
import io.yeobi.cattoy.controller.ProductService;
import io.yeobi.cattoy.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * @author yeobi
 * @created 2019-10-24
 */
public class ProductServiceTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    public void getProductsWithEmpty() {
        List<Product> products = new ArrayList<>();

        // Given
        given(productRepository.findAll()).willReturn(products);

        MockitoAnnotations.initMocks(this); // 나한테 있는 Mock 부터있는 객체들을 모두 초기화 해준다.

        assertThat(productService.getProducts()).isEmpty();
    }

    @Test
    public void getProductsWithOneProduct() {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().name("쥐돌이").build());

        // Given
        given(productRepository.findAll()).willReturn(products);

        MockitoAnnotations.initMocks(this); // 나한테 있는 Mock 부터있는 객체들을 모두 초기화 해준다.

        assertThat(productService.getProducts()).isNotEmpty();
    }



    @Test
    public void add() {
        productService.addProduct("쥐돌이");

        verify(productRepository).save(any());    // save 되었는지 확인. any : 어떤 것이든
    }

}
