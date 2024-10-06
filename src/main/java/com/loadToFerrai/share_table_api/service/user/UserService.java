package com.loadToFerrai.share_table_api.service.user;

import com.loadToFerrai.share_table_api.dto.UserDto;
import com.loadToFerrai.share_table_api.dto.authorizationDto.RegisterUserDetailBody;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.exception.ExistDataException;
import com.loadToFerrai.share_table_api.exception.NotFoundDataException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto signUp(User user);
    Boolean validateDuplicatedNickName(String nickName);

    User findUser(UserAgentInfo userAgentInfo);
    Optional<User> findUserOptional(UserAgentInfo userAgentInfo);
    UserDto findUserDTO(UserAgentInfo userAgentInfo) throws NotFoundDataException, ExistDataException;

    User findUserByNickName(String nickName);
    Optional<User> findUserOptionalByNickName(String nickName);
    UserDto findUserDTOByNickName(String nickName);

    List<User> findAllUser();
    List<UserDto> findAllUserDTO();

    Boolean registerUserDetail(RegisterUserDetailBody registerUserDetailBody);

    UserDto toDTO(User user);
    User toEntity(UserDto userDTO);
}
