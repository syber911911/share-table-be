package com.loadToFerrai.share_table_api.service.restaurant;

import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantDto;
import com.loadToFerrai.share_table_api.dto.restaurant.UpdateRestaurantInfoBody;
import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    RestaurantDto registerRestaurant(Restaurant restaurant);
    boolean updateRestaurantInfo(UpdateRestaurantInfoBody body);
    boolean deleteRestaurantInfo(Long restaurantId);

    Restaurant findRestaurant(Long id);
    Optional<Restaurant> findRestaurantOptional(Long id);
    RestaurantDto findRestaurantDTO(Long id);

    List<Restaurant> findAllRestaurant();
    List<Restaurant> findRestaurantFitTheName(String restaurantName);
    List<Restaurant> findRestaurantAddress(Address address);

    RestaurantDto toDTO(Restaurant restaurant);
}
