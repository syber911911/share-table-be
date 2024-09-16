package com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class KakaoResponseDTO {

    private Long id;
    private Boolean has_signed_up;
    private LocalDateTime connected_at;
    private LocalDateTime synched_at;
    //Todo 프로퍼티 값 정의하기
    private Properties properties;
    private KakaoAccount kakaoAccount;
    private Partner partner;

}
