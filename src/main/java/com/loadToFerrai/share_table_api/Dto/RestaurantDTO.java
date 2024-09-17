package com.loadToFerrai.share_table_api.Dto;

import com.loadToFerrai.share_table_api.Entity.Embedded.Address;
import com.loadToFerrai.share_table_api.Entity.Embedded.RestaurantCategory;
import jakarta.persistence.Embedded;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class RestaurantDTO {

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

    private Integer avgRatings;

    private Timestamp createdAt;
    private Timestamp deletedAt;
    private Timestamp modifiedAt;

    @Builder
    public RestaurantDTO(Address address, RestaurantCategory restaurantCategory,
                         String name, String menuInfo, String imgUrl,
                         String tel, String runtime,
                         Double let, Double lon, Integer avgRatings,
                         Timestamp createdAt, Timestamp deletedAt, Timestamp modifiedAt) {
        this.address = address;
        this.restaurantCategory = restaurantCategory;
        this.name = name;
        this.menuInfo = menuInfo;
        this.imgUrl = imgUrl;
        this.tel = tel;
        this.runtime = runtime;
        this.let = let;
        this.lon = lon;
        this.avgRatings = avgRatings;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.modifiedAt = modifiedAt;
    }
}
