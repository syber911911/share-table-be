package com.loadToFerrai.share_table_api.service.restaurant;


import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantDto;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantSearchCondition;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantInfoBody;
import com.loadToFerrai.share_table_api.entity.Restaurant;
import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.repository.restaurant.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto registerRestaurant(RestaurantInfoBody body) {
        Restaurant restaurant = Restaurant.builder()
                .address(body.getAddress())
                .restaurantCategory(body.getRestaurantCategory())
                .name(body.getName())
                .menuInfo(body.getMenuInfo())
                .imgUrl(body.getImgUrl())
                .tel(body.getTel())
                .let(body.getLet())
                .lon(body.getLon())
                .avgRatings(0)
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .deletedAt(null)
                .modifiedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        return toDTO(restaurantRepository.save(restaurant));
    }

    @Override
    public boolean updateRestaurantInfo(RestaurantInfoBody body) {
        Long isSuccess = restaurantRepository.updateRestaurantInfo(body);
        return isSuccess != 0;
    }

    @Override
    public boolean deleteRestaurantInfo(Long restaurantId) {
        Long isSuccess = restaurantRepository.deleteRestaurant(restaurantId);
        return isSuccess != 0;
    }

    @Override
    public boolean existRestaurantInfo(String restaurantName, Address address) {
        Optional<Restaurant> result = restaurantRepository.findByNameAndAddress(restaurantName, address);
        return result.isPresent();
    }

    @Override
    public Restaurant findPKRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Optional<Restaurant> findPKRestaurantOptional(Long id) {
        return restaurantRepository.findByIdOptional(id);
    }

    @Override
    public RestaurantDto findPKRestaurantDTO(Long id) {
        return toDTO(restaurantRepository.findById(id));
    }

    @Override
    public Page<RestaurantDto> findRestaurantByFilter(RestaurantSearchCondition condition, Pageable pageable) {
        Page<Restaurant> result = restaurantRepository.findByWholeCondition(condition, pageable);

        List<RestaurantDto> content = result.getContent()
                .stream()
                .map(this::toDTO)
                .toList();

        return new PageImpl<>(content, pageable, result.getTotalElements());
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
