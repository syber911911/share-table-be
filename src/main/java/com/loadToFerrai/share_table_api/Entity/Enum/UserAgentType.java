package com.loadToFerrai.share_table_api.Entity.Enum;

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
}