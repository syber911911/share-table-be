package com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@PropertySource("/properties/AuthorizationProperties.properties")
public class KakaoRequestDto {

    @Value("") // TODO 프로퍼티로 API 관리 (추가작성 해야함.)
    private String uri;


}
