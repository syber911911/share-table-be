package com.loadToFerrai.share_table_api.dto.restaurant;

import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.entity.embedded.RestaurantCategory;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantInfoBody {

    @Embedded
    private Address address;
    @Embedded
    private RestaurantCategory restaurantCategory;

    private String name;
    private String menuInfo;
    private String imgUrl;
    private String tel;
    private String runtime;

    private Double let;
    private Double lon;
}
