package com.loadToFerrai.share_table_api.Entity.Enum;

import lombok.Getter;

@Getter
public enum UserAuthorityType {
    // TODO 임시 권한 TOBE-Security에서 관리
    USER("일반 사용자"),
    BAD_USER("부정 사용자"),
    MANAGER("일반 관리자"),
    ADMIN("최고 관리자")
    ;
    private final String label;

    UserAuthorityType(String label) {
        this.label = label;
    }
}
