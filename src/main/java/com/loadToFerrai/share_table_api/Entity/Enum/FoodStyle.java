package com.loadToFerrai.share_table_api.Entity.Enum;

import lombok.Getter;

@Getter
public enum FoodStyle {
    KOREAN("한식"),
    WESTERN("양식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    SOUTHEAST_ASIAN("동남아식")
    ;
    private final String label;

    FoodStyle(String label) {
        this.label = label;
    }
}
