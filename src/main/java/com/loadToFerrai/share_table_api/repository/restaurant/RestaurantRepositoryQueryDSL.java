package com.loadToFerrai.share_table_api.repository.restaurant;


import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantSearchCondition;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantInfoBody;
import com.loadToFerrai.share_table_api.entity.embedded.Address;
import com.loadToFerrai.share_table_api.entity.Restaurant;
import com.loadToFerrai.share_table_api.entity.embedded.RestaurantCategory;
import com.loadToFerrai.share_table_api.entity.enums.FoodStyle;
import com.loadToFerrai.share_table_api.entity.enums.SalesStyle;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.loadToFerrai.share_table_api.entity.QRestaurant.restaurant;
import static com.loadToFerrai.share_table_api.repository.QueryDSLUtil.nullSafeBuilder;

// https://velog.io/@balparang/Querydsl-BooleanExpression-%EB%A5%BC-%EC%A1%B0%ED%95%A9%ED%95%A0-%EB%95%8C-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-NPE-%EB%8C%80%EC%B2%98%ED%95%98%EA%B8%B0
// -> booleanBuilder Null-Safe

// https://sungtae-kim.tistory.com/76 -> 한글 정렬
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
    public Optional<Restaurant> findByNameAndAddress(String name, Address address) {
        return Optional.ofNullable(jpaQueryFactory
                .selectFrom(restaurant)
                .where(restaurant.name.eq(name)
                        .and(addressBuilder(address)))
                .fetchOne());
    }

    @Override
    public Page<Restaurant> findByWholeCondition(RestaurantSearchCondition condition, Pageable pageable) {
        List<Restaurant> content = jpaQueryFactory
                .selectFrom(restaurant)
                .where(addressBuilder(condition.getRestaurantAddress())
                        .and(categoryBuilder(condition.getRestaurantCategory()))
                        .and(nameContains(condition.getRestaurantName())))
                .fetch();

        JPAQuery<Long> count = jpaQueryFactory
                .select(restaurant.count())
                .from(restaurant)
                .where(addressBuilder(condition.getRestaurantAddress())
                        .and(categoryBuilder(condition.getRestaurantCategory()))
                        .and(nameContains(condition.getRestaurantName())));

        return PageableExecutionUtils.getPage(content, pageable, count::fetchOne);
    }

    @Override
    public Long updateRestaurantInfo(RestaurantInfoBody body) {
        return jpaQueryFactory
                .update(restaurant)
                .set(restaurant.address, body.getAddress())
                .set(restaurant.restaurantCategory, body.getRestaurantCategory())
                .set(restaurant.name, body.getName())
                .set(restaurant.menuInfo, body.getMenuInfo())
                .set(restaurant.imgUrl, body.getImgUrl())
                .set(restaurant.tel, body.getTel())
                .set(restaurant.runtime, body.getRuntime())
                .set(restaurant.let, body.getLet())
                .set(restaurant.lon, body.getLon())
                .execute();
    }

    @Override
    public Long deleteRestaurant(Long Id) {
        return jpaQueryFactory.delete(restaurant)
                .where(restaurant.id.eq(Id))
                .execute();
    }

    private BooleanBuilder categoryBuilder(RestaurantCategory category) {
        return foodStyleEq(category.getFoodStyle())
                .and(salesStyleEq(category.getSalesStyle()));
    }

    private BooleanBuilder salesStyleEq(SalesStyle salesStyle) {
        return nullSafeBuilder(() -> restaurant.restaurantCategory.salesStyle.eq(salesStyle));
    }

    private BooleanBuilder foodStyleEq(FoodStyle foodStyle) {
        return nullSafeBuilder(() -> restaurant.restaurantCategory.foodStyle.eq(foodStyle));
    }

    private BooleanBuilder nameContains(String restaurantName) {
        return nullSafeBuilder(() -> restaurant.name.contains(restaurantName));
    }

    private BooleanBuilder addressBuilder(Address address) {
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
