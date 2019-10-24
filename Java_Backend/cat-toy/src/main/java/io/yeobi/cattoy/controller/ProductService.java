package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Service
public class ProductService {   // 예전에는 클래스를 만드는 것이 아니라 그 사이에 인터페이스를 두었다.

    public List<Product> getProducts() {
        return new ArrayList<>();
    }

}
