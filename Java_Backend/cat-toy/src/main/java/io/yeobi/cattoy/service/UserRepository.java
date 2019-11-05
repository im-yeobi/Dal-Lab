package io.yeobi.cattoy.service;

import io.yeobi.cattoy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yeobi
 * @created 2019-11-05
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
