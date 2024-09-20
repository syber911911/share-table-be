package com.loadToFerrai.share_table_api.service.restaurant;


import com.loadToFerrai.share_table_api.dto.RestaurantDto;
import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.entity.Restaurant;
import com.loadToFerrai.share_table_api.repository.restaurant.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto registerRestaurant(Restaurant restaurant) {
        return toDTO(restaurantRepository.save(restaurant));
    }

    @Override
    public Restaurant findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Optional<Restaurant> findRestaurantOptional(Long id) {
        return restaurantRepository.findByIdOptional(id);
    }

    @Override
    public RestaurantDto findRestaurantDTO(Long id) {
        return toDTO(findRestaurant(id));
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findRestaurantFitTheName(String restaurantName) {
        return restaurantRepository.findByName(restaurantName);
    }

    @Override
    public List<Restaurant> findRestaurantAddress(Address address) {
        return restaurantRepository.findByAddress(address);
    }

    @Override
    public RestaurantDto toDTO(Restaurant restaurant) {
        return RestaurantDto.builder()
                .address(restaurant.getAddress())
                .restaurantCategory(restaurant.getRestaurantCategory())
                .name(restaurant.getName())
                .menuInfo(restaurant.getMenuInfo())
                .imgUrl(restaurant.getImgUrl())
                .tel(restaurant.getTel())
                .runtime(restaurant.getRuntime())
                .let(restaurant.getLet())
                .lon(restaurant.getLon())
                .avgRatings(restaurant.getAvgRatings())
                .createdAt(restaurant.getCreatedAt())
                .deletedAt(restaurant.getDeletedAt())
                .modifiedAt(restaurant.getModifiedAt())
                .build();
    }
}
