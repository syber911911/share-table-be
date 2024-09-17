package com.loadToFerrai.share_table_api.controller;

import com.loadToFerrai.share_table_api.dto.authorizationDto.LoginRequestBody;
import com.loadToFerrai.share_table_api.dto.ResponseDto;
import com.loadToFerrai.share_table_api.dto.UserDto;
import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.exception.ExistUserException;
import com.loadToFerrai.share_table_api.service.user.UserService;
import com.loadToFerrai.share_table_api.util.JWTDecoder.AppleJWTUtil;
import com.loadToFerrai.share_table_api.util.WebClient.WebClientUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiUser")
public class UserController {
    private final UserService userService;
    private final WebClientUtil webClientUtil;
    private final AppleJWTUtil appleJWTUtil;

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return httpHeaders;
    }

    @PostMapping("/") // TODO 반환타입과 URI는 차후 설정
    public ResponseEntity<ResponseDto> checkUserInfo(@RequestBody LoginRequestBody requestBody) throws ExistUserException {
        UserDto findUser = userService.findUserDTOOptional(requestBody.getAgentUserId());

        if (findUser.getUserAgentInfo() == null) {
            String agentUserId = switch (requestBody.getAgentType()) {
                case KAKAO -> webClientUtil.getKakaoUserInfo(requestBody.getToken()).getId().toString();
                case APPLE -> appleJWTUtil.decodeIdToken(requestBody.getToken()).getId();
            };

            User user = new User(new UserAgentInfo(agentUserId, requestBody.getAgentType()));
            userService.signUp(user);
        }

        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<String>(Boolean.TRUE, "success"));
    }
}
