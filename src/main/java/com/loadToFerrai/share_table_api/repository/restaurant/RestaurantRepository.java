package com.loadToFerrai.share_table_api.repository.restaurant;

import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    void save(Restaurant restaurant);

    Restaurant findById(Long Id);
    Optional<Restaurant> findByIdOptional(Long Id);

    List<Restaurant> findAll();
    List<Restaurant> findByName(String restaurantName);
    List<Restaurant> findByAddress(Address address);
    // TODO 식당 리스트 페이징 추가해야함
}
