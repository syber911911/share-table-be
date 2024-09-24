package com.loadToFerrai.share_table_api.service.user;

import com.loadToFerrai.share_table_api.dto.UserDto;
import com.loadToFerrai.share_table_api.dto.authorizationDto.RegisterUserDetail;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.exception.ExistUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto signUp(User user);
    Boolean validateDuplicatedNickName(String nickName) throws ExistUserException;

    User findUser(UserAgentInfo userAgentInfo);
    UserDto findUserDTO(UserAgentInfo userAgentInfo);

    Optional<User> findUserOptional(UserAgentInfo userAgentInfo);
    UserDto findUserDTOOptional(UserAgentInfo userAgentInfo);

    User findUserByNickName(String nickName);
    UserDto findUserDTOByNickName(String nickName);

    List<User> findAllUser();
    List<UserDto> findAllUserDTO();

    Boolean registerUserDetail(RegisterUserDetail registerUserDetail);

    UserDto toDTO(User user);
    User toEntity(UserDto userDTO);
}
