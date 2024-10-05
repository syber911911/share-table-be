package com.loadToFerrai.share_table_api.dto.restaurant;


import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.entity.embedded.RestaurantCategory;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantSearchCondition {

    private String restaurantName;

    @Embedded
    private Address restaurantAddress;

    @Embedded
    private RestaurantCategory restaurantCategory;

}
