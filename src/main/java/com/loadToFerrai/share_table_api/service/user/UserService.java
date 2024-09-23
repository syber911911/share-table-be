package com.loadToFerrai.share_table_api.service.user;

import com.loadToFerrai.share_table_api.dto.UserDto;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.exception.ExistUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto signUp(User user);
    Boolean validateDuplicatedNickName(String nickName) throws ExistUserException;

    User findUser(String userAgentId);
    UserDto findUserDTO(String userAgentId);

    Optional<User> findUserOptional(String userAgentId);
    UserDto findUserDTOOptional(String userAgentId);

    User findUserByNickName(String nickName);
    UserDto findUserDTOByNickName(String nickName);

    List<User> findAllUser();
    List<UserDto> findAllUserDTO();

    UserDto toDTO(User user);
    User toEntity(UserDto userDTO);
}
