package io.yeobi.cattoy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@RestController
public class ProductController {

    @GetMapping("/products")
    public void list() {
        // TODO: 만들어야 함
    }


}
