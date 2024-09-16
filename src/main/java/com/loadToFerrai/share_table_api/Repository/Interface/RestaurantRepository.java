package com.loadToFerrai.share_table_api.Repository.Interface;

import com.loadToFerrai.share_table_api.Entity.Embedded.Address;
import com.loadToFerrai.share_table_api.Entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    void save(Restaurant restaurant);

    Restaurant findById(Long Id);
    Optional<Restaurant> findByIdOptional(Long Id);

    List<Restaurant> findAll();
    List<Restaurant> findByName(String restaurantName);

    List<Restaurant> findByAddressFull(Address address);
    List<Restaurant> findByAddressDoName(Address address);
    List<Restaurant> findByAddressSiName(Address address);
    List<Restaurant> findByAddressRoadName(Address address);

}
