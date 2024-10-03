package com.loadToFerrai.share_table_api.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum SalesStyle {

    DELIVERY("배달전용","DELIVERY"),
    TAKEOUT("포장전용","TAKEOUT"),
    HALL("홀전용","HALL"),
    WHOLE("전체","WHOLE")
    ;
    private final String label;
    private final String value;

    SalesStyle(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @JsonCreator
    public static SalesStyle jsonToEnum(String json) {
        return SalesStyle.valueOf(json.toUpperCase());
    }
}
