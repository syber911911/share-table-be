package com.loadToFerrai.share_table_api.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum Gender {

    MALE("남성","MALE"),
    FEMALE("여성", "FEMALE"),
    UNSPECIFIED("미지정", "UNSPECIFIED");
    ;

    private final String label;
    private final String value;

    Gender(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @JsonCreator
    public static Gender jsonToEnum(String json) {
        return Gender.valueOf(json.toUpperCase());
    }
}
