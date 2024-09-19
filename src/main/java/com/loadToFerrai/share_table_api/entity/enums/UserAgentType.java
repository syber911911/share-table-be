package com.loadToFerrai.share_table_api.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum UserAgentType {
    APPLE("애플"),
    KAKAO("카카오")
    ;

    private final String label;

    UserAgentType(String label) {
        this.label = label;
    }


    @JsonCreator
    public static UserAgentType jsonToEnum(String json) {
        return UserAgentType.valueOf(json.toUpperCase());
    }

}
