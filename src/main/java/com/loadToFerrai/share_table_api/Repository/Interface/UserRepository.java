package com.loadToFerrai.share_table_api.Repository.Interface;

import com.loadToFerrai.share_table_api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserAgentId(String userAgentId);
    Optional<User> findOptionalByUserAgentId(String userAgentId);
}
