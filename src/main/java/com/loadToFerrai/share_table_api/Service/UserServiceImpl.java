package com.loadToFerrai.share_table_api.Service;

import com.loadToFerrai.share_table_api.Dto.UserDTO;
import com.loadToFerrai.share_table_api.Entity.User;
import com.loadToFerrai.share_table_api.Repository.Interface.UserRepository;
import com.loadToFerrai.share_table_api.Service.Interface.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Boolean validateDuplicatedUser() {
//        return userRepository.findOptionalByUserAgentId(userAgentId).isPresent();
        return null;
    }

    @Override
    public User findUser(String userAgentId) {
        return userRepository.findUserByUserAgentId(userAgentId);
//        return userRepository.findOptionalByUserAgentId(userAgentId);
    }

    @Override
    public UserDTO findUserDTO(String userAgentId) {
        return toDTO(userRepository.findUserByUserAgentId(userAgentId));
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> findAllUserDTO() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
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
