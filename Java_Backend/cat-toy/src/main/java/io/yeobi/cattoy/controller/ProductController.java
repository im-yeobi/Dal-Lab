package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.domain.Product;
import io.yeobi.cattoy.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@RestController
public class ProductController {

    @GetMapping("/products")
    public List<ProductDto> list() {
        // TODO: 만들어야 함
        // DTO 개념이 들어갔다
        Product product = Product.builder().name("쥐돌이").build();

        List<Product> products = new ArrayList<>();
        products.add(product);

        // 여기 위는 application에서 처리

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());

        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(productDto);

        return productDtos;
    }


}
