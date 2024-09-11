package com.loadToFerrai.share_table_api.Repository.Interface;

import com.loadToFerrai.share_table_api.Entity.User;

import java.util.Optional;

public interface UserRepositoryCustom {
    User findUserByUserAgentId(String userAgentId);
    Optional<User> findOptionalByUserAgentId(String userAgentId);
}
