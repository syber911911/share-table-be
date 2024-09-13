package com.loadToFerrai.share_table_api.Repository.Interface;


import com.loadToFerrai.share_table_api.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    User findById(Long id);
    Optional<User> findByIdOptional(Long id);

    List<User> findAll();

    User findUserByUserAgentId(String userAgentId);
    Optional<User> findOptionalByUserAgentId(String userAgentId);
}
