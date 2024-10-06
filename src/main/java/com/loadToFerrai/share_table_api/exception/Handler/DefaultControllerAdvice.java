package com.loadToFerrai.share_table_api.exception.Handler;

import com.loadToFerrai.share_table_api.dto.ResponseDto;
import com.loadToFerrai.share_table_api.exception.ExistDataException;
import com.loadToFerrai.share_table_api.exception.NotFoundDataException;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.loadToFerrai.share_table_api.controller.controllerUtil.HeadersUtil.getHeaders;

@Slf4j
@RestControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(ExistDataException.class)
    public ResponseEntity<ResponseDto> existDataException(ExistDataException exception) {
        return ResponseEntity.badRequest()
                .headers(getHeaders())
                .body(new ResponseDto<String>(false, exception.getMessage()));
    }

    @ExceptionHandler(NotFoundDataException.class)
    public ResponseEntity<ResponseDto> notFoundDataException(NotFoundDataException exception) {
        return ResponseEntity.status(404)
                .headers(getHeaders())
                .body(new ResponseDto<String>(false, exception.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDto> illegalArgumentException(IllegalArgumentException exception){
        return ResponseEntity.badRequest()
                .headers(getHeaders())
                .body(new ResponseDto<String>(false, exception.getMessage()));
    }


}
