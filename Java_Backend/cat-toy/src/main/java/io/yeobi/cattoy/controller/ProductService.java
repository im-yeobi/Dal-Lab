package io.yeobi.cattoy.controller;

import io.yeobi.cattoy.Repository.ProductRepository;
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

    private ProductRepository productRepository;

    // 생성자 주입 사용.
    // 한번 생성하면 변경할 일이 없기 때문에
    // 롬복을 사용할 수도
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ArrayList<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return productRepository.findAll();   // List로 다시 묶는 이유는 뭘까?
    }

    public void addProduct(String name) {
        Product product = Product.builder().name(name).build();

        products.add(product);
    }
}
