package com.loadToFerrai.share_table_api.repository.restaurant;

import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantSearchCondition;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantInfoBody;
import com.loadToFerrai.share_table_api.entity.Restaurant;
import com.loadToFerrai.share_table_api.entity.embedded.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    Restaurant findById(Long Id);
    Optional<Restaurant> findByIdOptional(Long Id);

    Optional<Restaurant> findByNameAndAddress(String name, Address address);
    Page<Restaurant> findByWholeCondition(RestaurantSearchCondition condition, Pageable pageable);

    Long updateRestaurantInfo(RestaurantInfoBody body);
    Long deleteRestaurant(Long Id);
    Long readyToDeleteRestaurant(Long Id);
    // TODO 식당 리스트 페이징 추가해야함
}
