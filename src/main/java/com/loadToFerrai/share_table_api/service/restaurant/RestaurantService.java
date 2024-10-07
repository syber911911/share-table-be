package com.loadToFerrai.share_table_api.service.restaurant;

import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantDto;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantSearchCondition;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantInfoBody;
import com.loadToFerrai.share_table_api.entity.Restaurant;
import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.exception.ExistDataException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RestaurantService {
    RestaurantDto registerRestaurant(RestaurantInfoBody body);
    boolean updateRestaurantInfo(RestaurantInfoBody body);
    boolean deleteRestaurantInfo(Long restaurantId);
    Long inactivateRestaurant(Long restaurantId) throws IllegalArgumentException;

    void existRestaurantInfo(String restaurantName, Address address) throws ExistDataException;

    Restaurant findPKRestaurant(Long id);
    Optional<Restaurant> findPKRestaurantOptional(Long id);
    RestaurantDto findPKRestaurantDTO(Long id);

    Page<RestaurantDto> findRestaurantByFilter(RestaurantSearchCondition condition, Pageable pageable);


    RestaurantDto toDTO(Restaurant restaurant);
}
