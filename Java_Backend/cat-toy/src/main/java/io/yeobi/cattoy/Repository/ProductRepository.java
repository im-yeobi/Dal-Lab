package io.yeobi.cattoy.Repository;

import io.yeobi.cattoy.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Repository
public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);

}
