package com.loadToFerrai.share_table_api.exception.Handler;

import com.loadToFerrai.share_table_api.dto.ResponseDto;
import com.loadToFerrai.share_table_api.exception.ExistUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.loadToFerrai.share_table_api.controller.controllerUtil.HeadersUtil.getHeaders;

@RestControllerAdvice(assignableTypes = {UserControllerAdvice.class})
public class UserControllerAdvice {

    @ExceptionHandler(ExistUserException.class)
    public ResponseEntity<ResponseDto> existUserException() {
        return ResponseEntity.badRequest()
                .headers(getHeaders())
                .body(new ResponseDto<String>(false, "User is Not Exist"));
    }

}
