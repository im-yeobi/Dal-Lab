package io.yeobi.cattoy.Repository;

import io.yeobi.cattoy.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeobi
 * @created 2019-10-24
 */
// CrudRepository를 사용할 수도 있지만 페이지네이션 등 JPA의 모든 것 사용하기 위해 JpaRepository 사용
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {   // 도메인 모델 객체, 키.

    List<Product> findAll();

    Product save(Product product);

}
