package com.loadToFerrai.share_table_api.Service;

import com.loadToFerrai.share_table_api.Dto.UserDTO;
import com.loadToFerrai.share_table_api.Entity.User;
import com.loadToFerrai.share_table_api.Repository.Interface.UserRepository;
import com.loadToFerrai.share_table_api.Service.Interface.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void signUp(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean validateDuplicatedUser(String userAgentId) {
        return userRepository.findOptionalByUserAgentId(userAgentId).isPresent();
    }

    @Override
    public User findUser(String userAgentId) {
        return userRepository.findUserByUserAgentId(userAgentId);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .userName(user.getUserName())
                .userEmailAddress(user.getUserEmailAddress())
                .userAgeRange(user.getUserAgeRange())
                .userProfileNickname(user.getUserProfileNickname())
                .userProfileIMG(user.getUserProfileIMG())
                /*.userAgentId(user.getUserAgentId())*/
                .userGender(user.getUserGender())
                .userAuthorityType(user.getUserAuthorityType())
                .userAgentType(user.getUserAgentType())
                .build();
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }
}
