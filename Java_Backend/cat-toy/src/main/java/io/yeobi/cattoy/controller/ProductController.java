package io.yeobi.cattoy.controller;

import com.github.dozermapper.core.Mapper;
import io.yeobi.cattoy.domain.Product;
import io.yeobi.cattoy.dto.ProductDto;
import io.yeobi.cattoy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@RestController
public class ProductController {

    @Autowired
    Mapper mapper;

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> list() {    // 반환형을 Stream으로 할 수도 있다.
      List<Product> products = productService.getProducts();  // List를 또 다른 List로 바꾸기 위해 Stream을 사용한다.

        // Stream => functional program
        return products.stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/products")
    public ResponseEntity<?> create(
            @RequestBody ProductDto productDto
    ) throws URISyntaxException {
        String name = productDto.getName();
        String maker = productDto.getMaker();
        Integer price = productDto.getPrice();
        productService.addProduct(name, maker, price);

        URI location = new URI("/products/1004");
        return ResponseEntity.created(location).build();
    }

}
