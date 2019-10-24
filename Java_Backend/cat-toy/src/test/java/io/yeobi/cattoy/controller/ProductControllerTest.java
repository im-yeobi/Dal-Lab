package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.domain.Product;
import io.yeobi.cattoy.dto.ProductDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Before
    public void mockProductService() {
        // 가짜로 주입하는 것들
        // Given
        Product product = Product.builder().name("쥐돌이").build();

        List<Product> products = new ArrayList<>();
        products.add(product);

        given(productService.getProducts()).willReturn(products);
    }

    /**
     * GET /products
     */
    @Test
    public void list() throws Exception {   // 에러가 나는 것을 먼저 확인. 메소드 명은 GET_list로 해도 무방하다.
        // 아래는 실제로 테스트 하는 것들
        // 컨트롤러를 통해 테스트 하고자 하는것
        // 1. 상품 목록
        // 2. 제대로 상품 목록을 DTO로 변환하여 JSON 형태로 반환하는 것
        // 위 목적을 제외하고 Service에 대한 것들은 가짜로 만든다.
        ProductDto productDto = new ProductDto();
        productDto.setName("쥐돌이");

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("쥐돌이")));

        verify(productService).getProducts();   // 메소드 호출 확인
    }

}