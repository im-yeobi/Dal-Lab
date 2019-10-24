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
public class ProductService {

    private ArrayList<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return new ArrayList<>(products);   // List로 다시 묶는 이유는 뭘까?
    }

    public void addProduct(String name) {
        Product product = Product.builder().name(name).build();

        products.add(product);
    }
}
