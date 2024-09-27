package com.loadToFerrai.share_table_api.entity.embedded;


import com.loadToFerrai.share_table_api.entity.enums.FoodStyle;
import com.loadToFerrai.share_table_api.entity.enums.SalesStyle;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantCategory {

    @Enumerated(EnumType.STRING)
    private SalesStyle salesStyle;

    @Enumerated(EnumType.STRING)
    private FoodStyle foodStyle;

}
