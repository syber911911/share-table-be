package com.loadToFerrai.share_table_api.Repository;


import com.loadToFerrai.share_table_api.Entity.Embedded.Address;
import com.loadToFerrai.share_table_api.Entity.QRestaurant;
import com.loadToFerrai.share_table_api.Entity.Restaurant;
import com.loadToFerrai.share_table_api.Repository.Interface.RestaurantRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.loadToFerrai.share_table_api.Entity.QRestaurant.restaurant;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryQueryDSL implements RestaurantRepository {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public void save(Restaurant restaurant) {
        em.persist(restaurant);
    }

    @Override
    public Restaurant findById(Long Id) {
        return em.find(Restaurant.class, Id);
    }

    @Override
    public Optional<Restaurant> findByIdOptional(Long Id) {
        return Optional.ofNullable(em.find(Restaurant.class, Id));
    }

    @Override
    public List<Restaurant> findAll() {
        return jpaQueryFactory
                .selectFrom(restaurant)
                .fetch();
    }

    @Override
    public List<Restaurant> findByName(String restaurantName) {
        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(restaurant.name.contains(restaurantName))
                .fetch();
    }

    @Override
    public List<Restaurant> findByAddressFull(Address address) {
        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(
                        restaurant.address.doName.eq(address.getDoName())
                        .and(restaurant.address.siName.eq(address.getSiName()))
                        .and(restaurant.address.roadName.eq(address.getRoadName()))
                        .and(restaurant.address.detail.eq(address.getDetail()))
                )
                .fetch();
    }

    @Override
    public List<Restaurant> findByAddressDoName(Address address) {
        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(restaurant.address.doName.eq(address.getDoName()))
                .fetch();
    }

    @Override
    public List<Restaurant> findByAddressSiName(Address address) {
        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(
                        restaurant.address.doName.eq(address.getDoName())
                        .and(restaurant.address.siName.eq(address.getSiName()))
                )
                .fetch();
    }

    @Override
    public List<Restaurant> findByAddressRoadName(Address address) {
        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(restaurant.address.roadName.eq(address.getRoadName()))
                .fetch();
    }

}
