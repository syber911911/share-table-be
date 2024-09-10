package com.loadToFerrai.share_table_api.Service.Interface;

import com.loadToFerrai.share_table_api.Dto.UserDTO;
import com.loadToFerrai.share_table_api.Entity.User;
import com.loadToFerrai.share_table_api.Exception.ExistUserException;

import java.util.List;

public interface UserService {

    void signUp(User user);
    Boolean validateDuplicatedUser(String userAgentId) throws ExistUserException;

    User findUser(String userAgentId);
    List<User> findAllUser();

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
