package io.yeobi.cattoy.service;

import io.yeobi.cattoy.Repository.ProductRepository;
import io.yeobi.cattoy.domain.Product;
import io.yeobi.cattoy.dto.ProductDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Service
@Transactional  // 트랜잭션 범위를 잡아주는 역할
public class ProductService {

    private ProductRepository productRepository;

    // 생성자 주입 사용.
    // 한번 생성하면 변경할 일이 없기 때문에
    // 롬복을 사용할 수도
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();   // List로 다시 묶는 이유는 뭘까?
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).get();    // Optional을 처리하긱 위해. orElse(null)은 null을 받는다. orElse(new Product)를 사용할 수도 있다.
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void updateProduct(Long id, ProductDto productDto) {
        // TODO
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);   // JPA에 기본으로 구현되어 있다.
    }
}
