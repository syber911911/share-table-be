package com.loadToFerrai.share_table_api.repository.user;


import com.loadToFerrai.share_table_api.dto.authorizationDto.RegisterUserDetail;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    User findById(Long id);
    Optional<User> findByIdOptional(Long id);

    List<User> findAll();

    User findUserByUserAgentId(UserAgentInfo userAgentInfo);
    Optional<User> findOptionalByUserAgentId(UserAgentInfo userAgentInfo);

    Long updateUserDetail(RegisterUserDetail userDetail);

    User findUserByUserProfileNickName(String userProfileNickName);
    Optional<User> findOptionalByUserProfileNickName(String userProfileNickName);
}
