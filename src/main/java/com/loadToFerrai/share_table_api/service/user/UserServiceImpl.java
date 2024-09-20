package com.loadToFerrai.share_table_api.service.user;

import com.loadToFerrai.share_table_api.dto.UserDto;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.repository.user.UserRepository;
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
    public UserDto signUp(User user) {
        return toDTO(userRepository.save(user));
    }

    @Override
    public Boolean validateDuplicatedUser() {
        //todo 필요할까? Optional 검사로 하면 되지 않나 싶기도
        return null;
    }

    @Override
    public User findUser(String userAgentId) {
        return userRepository.findUserByUserAgentId(userAgentId);
    }

    @Override
    public UserDto findUserDTO(String userAgentId) {
        return toDTO(userRepository.findUserByUserAgentId(userAgentId));
    }

    @Override
    public Optional<User> findUserOptional(String userAgentId) {
        return userRepository.findOptionalByUserAgentId(userAgentId);
    }

    @Override
    public UserDto findUserDTOOptional(String userAgentId) {
        UserDto emptyUserDTO = new UserDto();
        return userRepository.findOptionalByUserAgentId(userAgentId)
                .map(this::toDTO)
                .orElse(emptyUserDTO);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDto> findAllUserDTO() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto toDTO(User user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .userEmailAddress(user.getUserEmailAddress())
                .userAgeRange(user.getUserAgeRange())
                .userProfileNickname(user.getUserProfileNickname())
                .userProfileIMG(user.getUserProfileIMG())
                .userGender(user.getUserGender())
                .userAgentInfo(user.getUserAgentInfo())
                .userAuthorityType(user.getUserAuthorityType())
                .build();
    }

    @Override
    public User toEntity(UserDto userDTO) {
        return null;
    }
}
