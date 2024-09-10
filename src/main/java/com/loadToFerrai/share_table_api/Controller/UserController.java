package com.loadToFerrai.share_table_api.Controller;

import com.loadToFerrai.share_table_api.Dto.AuthorizationDto.LoginRequestBody;
import com.loadToFerrai.share_table_api.Exception.ExistUserException;
import com.loadToFerrai.share_table_api.Service.Interface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiUser")
public class UserController {
    private final UserService userService;

    @PostMapping("/") // TODO 반환타입과 URI는 차후 설정
    public void checkUserInfo(@RequestBody LoginRequestBody requestBody) throws ExistUserException {

    }
}
