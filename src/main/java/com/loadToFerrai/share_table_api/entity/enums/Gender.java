package com.loadToFerrai.share_table_api.entity.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("남성"),
    FEMALE("여성"),
    UNSPECIFIED("미지정")
    ;

    private final String label;

    Gender(String label) {
        this.label = label;
    }
}
