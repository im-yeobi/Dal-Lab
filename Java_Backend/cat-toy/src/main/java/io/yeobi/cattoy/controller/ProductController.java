package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.domain.Product;
import io.yeobi.cattoy.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> list() {
        // TODO: 만들어야 함
        // DTO 개념이 들어갔다
//        Product product = Product.builder().name("쥐돌이").build();
//
//        List<Product> products = new ArrayList<>();
//        products.add(product);

        // 여기 위는 application에서 처리

        List<Product> products = productService.getProducts();  // List를 또 다른 List로 바꾸기 위해 Stream을 사용한다.

        // Stream => functional program
        return products.stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            return productDto;
        }).collect(Collectors.toList());
    }


}
