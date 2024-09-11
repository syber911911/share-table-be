package com.loadToFerrai.share_table_api.Service.Interface;

import com.loadToFerrai.share_table_api.Dto.UserDTO;
import com.loadToFerrai.share_table_api.Entity.User;
import com.loadToFerrai.share_table_api.Exception.ExistUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void signUp(User user);
    Boolean validateDuplicatedUser() throws ExistUserException;

    User findUser(String userAgentId);
    UserDTO findUserDTO(String userAgentId);

    Optional<User> findUserOptional(String userAgentId);
    UserDTO findUserDTOOptional(String userAgentId);

    List<User> findAllUser();
    List<UserDTO> findAllUserDTO();

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
