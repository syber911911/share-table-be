package com.loadToFerrai.share_table_api.entity.enums;

import lombok.Getter;

@Getter
public enum SalesStyle {

    DELIVERY("배달전용"),
    TAKEOUT("포장전용"),
    HALL("홀전용"),
    WHOLE("전체")
    ;
    private final String label;

    SalesStyle(String label) {
        this.label = label;
    }
}
