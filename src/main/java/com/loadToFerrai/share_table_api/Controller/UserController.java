package com.loadToFerrai.share_table_api.Controller;

import com.loadToFerrai.share_table_api.Dto.AuthorizationDto.LoginRequestBody;
import com.loadToFerrai.share_table_api.Dto.ResponseDTO;
import com.loadToFerrai.share_table_api.Dto.UserDTO;
import com.loadToFerrai.share_table_api.Entity.Embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.Entity.User;
import com.loadToFerrai.share_table_api.Exception.ExistUserException;
import com.loadToFerrai.share_table_api.Service.Interface.UserService;
import com.loadToFerrai.share_table_api.Util.JWTDecoder.AppleJWTUtil;
import com.loadToFerrai.share_table_api.Util.WebClient.WebClientUtil;
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
    public ResponseEntity<ResponseDTO> checkUserInfo(@RequestBody LoginRequestBody requestBody) throws ExistUserException {
        UserDTO findUser = userService.findUserDTOOptional(requestBody.getAgentUserId());

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
                .body(new ResponseDTO<String>(Boolean.TRUE, "success"));
    }
}
