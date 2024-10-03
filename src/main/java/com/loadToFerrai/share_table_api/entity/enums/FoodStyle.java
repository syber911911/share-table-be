package com.loadToFerrai.share_table_api.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum FoodStyle {
    KOREAN("한식","KOREAN"),
    WESTERN("양식","WESTERN"),
    JAPANESE("일식","JAPANESE"),
    CHINESE("중식","CHINESE"),
    SOUTHEAST_ASIAN("동남아식","SOUTHEAST_ASIAN"),
    FAST_FOOD("패스트푸드","FAST_FOOD")
    ;
    private final String label;
    private final String value;

    FoodStyle(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @JsonCreator
    public static FoodStyle jsonToEnum(String json) {
        return FoodStyle.valueOf(json.toUpperCase());
    }
}
