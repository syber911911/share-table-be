package com.loadToFerrai.share_table_api.controller;

import com.loadToFerrai.share_table_api.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AWSController {

    @GetMapping("/health")
    public ResponseEntity<ResponseDto<Object>> healthCheck() {

        ResponseDto<Object> responseDTO = new ResponseDto<>();
        responseDTO.setSuccess(true);
        responseDTO.setResult("AWS Health Check!");

        return ResponseEntity.ok(responseDTO);
    }
}
