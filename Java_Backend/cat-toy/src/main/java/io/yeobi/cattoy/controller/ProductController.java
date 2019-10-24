package io.yeobi.cattoy.controller;

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
        ProductDto productDto = new ProductDto();
        productDto.setName("쥐돌이");

        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(productDto);

        return productDtos;
    }


}
