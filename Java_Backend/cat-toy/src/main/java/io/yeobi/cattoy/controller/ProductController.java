package io.yeobi.cattoy.controller;

import com.github.dozermapper.core.Mapper;
import io.yeobi.cattoy.domain.Product;
import io.yeobi.cattoy.dto.ProductDto;
import io.yeobi.cattoy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products/{id}")
    public ProductDto detail(
            @PathVariable("id") Long id
    ) {
        Product product = productService.getProduct(id);

        return mapper.map(product, ProductDto.class);
    }

    @PostMapping("/products")
    public ResponseEntity<?> create(
            @RequestBody ProductDto productDto
    ) throws URISyntaxException {
        Product product = productService.addProduct(mapper.map(productDto, Product.class));

        URI location = new URI("/products/" + product.getId());
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/products/{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestBody ProductDto productDto
    ) {
        productService.updateProduct(id, productDto);   // 객체로 넘기라
    }

    @DeleteMapping("/products/{id}")
    public void destroy(@PathVariable Long id) {
        productService.removeProduct(id);
    }

}
