package com.loadToFerrai.share_table_api.service.user;

import com.loadToFerrai.share_table_api.dto.UserDto;
import com.loadToFerrai.share_table_api.dto.authorizationDto.RegisterUserDetailBody;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.exception.ExistUserException;
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
    public Boolean validateDuplicatedNickName(String nickName) {
        return userRepository.findOptionalByUserProfileNickName(nickName).isPresent();
    }

    @Override
    public User findUser(UserAgentInfo userAgentInfo) {
        return userRepository.findUserByUserAgentId(userAgentInfo);
    }

    @Override
    public UserDto findUserDTO(UserAgentInfo userAgentInfo) throws ExistUserException {
        User user = userRepository.findUserByUserAgentId(userAgentInfo);
        if(user == null) {
            throw new ExistUserException("User is not exist");
        }
        return toDTO(user);
    }

    @Override
    public Optional<User> findUserOptional(UserAgentInfo userAgentInfo) {
        return userRepository.findOptionalByUserAgentId(userAgentInfo);
    }

//    @Override
//    public UserDto findUserDTOOptional(UserAgentInfo userAgentInfo) {
//        UserDto emptyUserDTO = new UserDto();
//        return userRepository.findOptionalByUserAgentId(userAgentInfo)
//                .map(this::toDTO)
//                .orElse(emptyUserDTO);
//    }

    @Override
    public User findUserByNickName(String nickName) {
        return userRepository.findUserByUserProfileNickName(nickName);
    }

    @Override
    public Optional<User> findUserOptionalByNickName(String nickName) {
        return userRepository.findOptionalByUserProfileNickName(nickName);
    }

    @Override
    public UserDto findUserDTOByNickName(String nickName) {
        return toDTO(userRepository.findUserByUserProfileNickName(nickName));
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
    public Boolean registerUserDetail(RegisterUserDetailBody registerUserDetailBody) {
        Long isSuccess = userRepository.updateUserDetail(registerUserDetailBody);
        return isSuccess != 0;
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
