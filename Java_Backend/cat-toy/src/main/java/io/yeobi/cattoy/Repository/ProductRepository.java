package io.yeobi.cattoy.Repository;

import io.yeobi.cattoy.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author yeobi
 * @created 2019-10-24
 */
// CrudRepository를 사용할 수도 있지만 페이지네이션 등 JPA의 모든 것 사용하기 위해 JpaRepository 사용
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {   // 도메인 모델 객체, 키.

    // 현재 사용하고 있는 메소드를 명시해준다. (개인의 스타일)
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

}
