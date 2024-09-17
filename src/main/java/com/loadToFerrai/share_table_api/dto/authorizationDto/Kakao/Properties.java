package com.loadToFerrai.share_table_api.dto.authorizationDto.Kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Properties {

    // Todo 프로퍼티 값 설정하기

    @JsonProperty("empty")
    private String empty;
}
