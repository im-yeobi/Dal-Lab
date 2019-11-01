package io.yeobi.cattoy.controller;

import com.github.dozermapper.core.Mapper;
import io.yeobi.cattoy.domain.Product;
import io.yeobi.cattoy.dto.ProductDto;
import io.yeobi.cattoy.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @SpyBean
    private Mapper mapper;

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
     * 상품 전체 조회 API 테스트
     */
    @Test
    public void list() throws Exception {   // 에러가 나는 것을 먼저 확인. 메소드 명은 GET_list로 해도 무방하다.
        // 아래는 실제로 테스트 하는 것들
        // 컨트롤러를 통해 테스트 하고자 하는것
        // 1. 상품 목록
        // 2. 제대로 상품 목록을 DTO로 변환하여 JSON 형태로 반환하는 것
        // 위 목적을 제외하고 Service에 대한 것들은 가짜로 만든다.
        ProductDto productDto = ProductDto.builder()
                .name("쥐돌이")
                .build();

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("쥐돌이")));

        verify(productService).getProducts();   // 메소드 호출 확인
    }

    /**
     * 상품 개별 조회 API 테스트
     * 조회하고자 하는 상품 있는 경우
     */
    @Test
    public void detailWhenExists() throws Exception {
        Product product = Product.builder()
                .name("쥐돌이")
                .maker("달랩")
                .price(5000)
                .build();

        given(productService.getProduct(13L)).willReturn(product);

        mockMvc.perform(
                get("/products/13")
        ).andExpect(status().isOk())
                .andExpect(content().string(containsString("쥐돌이")));

        verify(productService).getProduct(13L);
    }

    /**
     * 상품 개별 조회 API
     * 조회하고자 하는 상품 없는 경우
     */
    @Test
    public void detailWhenProductNotExists() throws Exception {
        given(productService.getProduct(13L))
                .willThrow(new EntityNotFoundException());

        mockMvc.perform(
                get("/products/13")
        ).andExpect(status().isNotFound());

        verify(productService).getProduct(13L);
    }

    @Test
    public void createWithValid() throws Exception {
        Product product = Product.builder()
                .id(1004L)
                .build();

        given(productService.addProduct(any(Product.class))).willReturn(product);

        mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"낚시대\", \"maker\":\"달랩\", " +
                                "\"price\":5000}")
        )
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/products/1004"));

        verify(productService).addProduct(any(Product.class));  // any이긴한데 해당 클래스면 다 된다
    }

    @Test
    public void createWithInvalidAttributes() throws Exception {
        mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"낚시대\", \"maker\":\"달랩\", " +
                                "\"price\":-5000}")
        )
                .andExpect(status().isBadRequest());    // BadRequest 400, isUnprocessable Entity 422
    }

    @Test
    public void updateWithValidAttributes() throws Exception {// JSON 넘겨주기
        mockMvc.perform(
                patch("/products/13")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"쥐돌이2\", \"maker\":\"달랩\", " +
                        "\"price\":5000}")
        )
                .andExpect(status().isOk());

        ProductDto productDto = ProductDto.builder()
                .name("쥐돌이2")
                .maker("달랩")
                .price(5000)
                .build();

        // 뭔가 바뀌기
        verify(productService).updateProduct(13L, productDto);
    }

    @Test
    public void updateWithInvalidAttributes() throws Exception {// JSON 넘겨주기
        mockMvc.perform(patch("/products/13")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\", \"maker\":\"달랩\", " +
                        "\"price\":5000}")
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateWithInvalidPrice() throws Exception {// JSON 넘겨주기
        mockMvc.perform(patch("/products/13")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"쥐돌이2\", \"maker\":\"달랩\", " +
                        "\"price\":-5000}")
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void destroy() throws Exception {
        mockMvc.perform(
                delete("/products/13")
        )
                .andExpect(status().isOk());

        verify(productService).removeProduct(13L);
    }

}