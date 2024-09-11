package com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
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
