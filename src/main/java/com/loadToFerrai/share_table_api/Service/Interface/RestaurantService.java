package com.loadToFerrai.share_table_api.Service.Interface;

import com.loadToFerrai.share_table_api.Dto.RestaurantDTO;
import com.loadToFerrai.share_table_api.Entity.Embedded.Address;
import com.loadToFerrai.share_table_api.Entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    void registerRestaurant(Restaurant restaurant);

    Restaurant findRestaurant(Long id);
    Optional<Restaurant> findRestaurantOptional(Long id);
    RestaurantDTO findRestaurantDTO(Long id);

    List<Restaurant> findAllRestaurant();
    List<Restaurant> findRestaurantFitTheName(String restaurantName);
    List<Restaurant> findRestaurantAddress(Address address);

    RestaurantDTO toDTO(Restaurant restaurant);
}
