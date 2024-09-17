package com.loadToFerrai.share_table_api.entity.embedded;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantCategory {

    private String salesStyle; // Enum
    private String foodStyle; // Enum
    // 추가예정
}
