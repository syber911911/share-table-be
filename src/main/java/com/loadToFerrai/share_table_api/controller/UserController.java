package com.loadToFerrai.share_table_api.controller;

import com.loadToFerrai.share_table_api.dto.authorizationDto.LoginRequestBody;
import com.loadToFerrai.share_table_api.dto.ResponseDto;
import com.loadToFerrai.share_table_api.dto.UserDto;
import com.loadToFerrai.share_table_api.dto.authorizationDto.RegisterUserDetailBody;
import com.loadToFerrai.share_table_api.dto.authorizationDto.RequestUserInfoBody;
import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.exception.ExistDataException;
import com.loadToFerrai.share_table_api.exception.NotFoundDataException;
import com.loadToFerrai.share_table_api.service.user.UserService;
import com.loadToFerrai.share_table_api.util.JWTDecoder.AppleJWTUtil;
import com.loadToFerrai.share_table_api.util.WebClient.WebClientUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.loadToFerrai.share_table_api.controller.controllerUtil.HeadersUtil.getHeaders;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiUser")
public class UserController {
    private final UserService userService;
    private final WebClientUtil webClientUtil;
    private final AppleJWTUtil appleJWTUtil;

    @GetMapping("/info")
    public ResponseEntity<ResponseDto> getUserInfo(@RequestBody RequestUserInfoBody requestUserInfoBody) throws NotFoundDataException {
        UserDto userDTO = userService.findUserDTO(requestUserInfoBody.getUserAgentInfo());

        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<UserDto>(true, userDTO));
    }

    @PostMapping("/signUp")
    public ResponseEntity<ResponseDto> signUpAndLogin(
            @RequestBody @Valid LoginRequestBody requestBody){
        UserDto findUser = userService.findUserDTO(requestBody.getUserAgentInfo());

        if (findUser.getUserAgentInfo() == null) {
            String agentUserId = switch (requestBody.getUserAgentInfo().getUserAgentType()) {
                case KAKAO -> webClientUtil.getKakaoUserInfo(requestBody.getToken()).getId().toString();
                case APPLE -> appleJWTUtil.decodeIdToken(requestBody.getToken()).getId();
            };

            User user = new User(new UserAgentInfo(agentUserId, requestBody.getUserAgentInfo().getUserAgentType()));
            findUser = userService.signUp(user);
        }

        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<UserDto>(true, findUser));
    }

    @GetMapping("/availableNickName")
    public ResponseEntity<ResponseDto> duplicatedUserNameChecker(
            @RequestParam("userName") @Length(max = 8) @Length(min = 2) String userName){

        if (userService.validateDuplicatedNickName(userName)) {
            return ResponseEntity.ok()
                    .headers(getHeaders())
                    .body(new ResponseDto<>(false, "사용할 수 없는 닉네임 입니다."));
        }

        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<>(true, "사용할 수 있는 닉네임 입니다."));
    }

    @PostMapping("/registerDetail")
    public ResponseEntity<ResponseDto> registerUserDetail(
            @RequestBody @Valid RegisterUserDetailBody registerUserDetailBody) throws NotFoundDataException {

        Boolean isSuccess = userService.registerUserDetail(registerUserDetailBody);

        if (!isSuccess) {
            return ResponseEntity.badRequest()
                    .headers(getHeaders())
                    .body(new ResponseDto<String>(false, "업데이트에 실패했습니다."));
        }

        UserDto userDTO = userService.findUserDTO(registerUserDetailBody.getUserAgentInfo());

        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<UserDto>(true, userDTO));
    }
}
