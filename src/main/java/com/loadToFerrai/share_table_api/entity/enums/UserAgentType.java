package com.loadToFerrai.share_table_api.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum UserAgentType {
    APPLE("애플","APPLE"),
    KAKAO("카카오","KAKAO")
    ;

    private final String label;
    private final String value;

    UserAgentType(String label, String value) {
        this.label = label;
        this.value = value;
    }


    @JsonCreator
    public static UserAgentType jsonToEnum(String json) {
        return UserAgentType.valueOf(json.toUpperCase());
    }

}
