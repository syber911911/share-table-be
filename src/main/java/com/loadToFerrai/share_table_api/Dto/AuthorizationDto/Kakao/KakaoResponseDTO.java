package com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KakaoResponseDTO {

    private Long id;
    private Boolean has_signed_up;
    private LocalDateTime connected_at;
    private LocalDateTime synched_at;
    //private JsonValue properties;
    private KakaoAccount kakaoAccount;
    private Partner partner;

}
