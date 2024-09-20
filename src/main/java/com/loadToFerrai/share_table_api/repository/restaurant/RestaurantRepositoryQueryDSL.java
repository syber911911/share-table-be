package com.loadToFerrai.share_table_api.repository.restaurant;


import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.entity.Restaurant;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.loadToFerrai.share_table_api.entity.QRestaurant.restaurant;
import static com.loadToFerrai.share_table_api.repository.QueryDSLUtil.nullSafeBuilder;

// https://velog.io/@balparang/Querydsl-BooleanExpression-%EB%A5%BC-%EC%A1%B0%ED%95%A9%ED%95%A0-%EB%95%8C-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-NPE-%EB%8C%80%EC%B2%98%ED%95%98%EA%B8%B0
// booleanBuilder Null-Safe

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryQueryDSL implements RestaurantRepository {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Restaurant save(Restaurant restaurant) {
        em.persist(restaurant);
        return restaurant;
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
    public List<Restaurant> findByAddress(Address address) {
        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(matchedAddressChecker(address))
                .fetch();
        // TODO Pagination 추가 요망
    }

    private BooleanBuilder matchedAddressChecker(Address address) {
        return doContains(address.getDoName())
                .and(siContains(address.getSiName()))
                .and(roadContains(address.getRoadName()))
                .and(detailEq(address.getDetail()));
    }

    private BooleanBuilder doContains(String doName) {
        return nullSafeBuilder(() -> restaurant.address.doName.contains(doName));
    }

    private BooleanBuilder siContains(String siName) {
        return nullSafeBuilder(() -> restaurant.address.siName.contains(siName));
    }

    private BooleanBuilder roadContains(String roadName) {
        return nullSafeBuilder(() -> restaurant.address.roadName.contains(roadName));
    }

    private BooleanBuilder detailEq(String detail) {
        return nullSafeBuilder(() -> restaurant.address.detail.eq(detail));
    }

}
