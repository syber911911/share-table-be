package com.loadToFerrai.share_table_api.entity.embedded;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRestaurantCategory is a Querydsl query type for RestaurantCategory
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QRestaurantCategory extends BeanPath<RestaurantCategory> {

    private static final long serialVersionUID = 700744274L;

    public static final QRestaurantCategory restaurantCategory = new QRestaurantCategory("restaurantCategory");

    public final EnumPath<com.loadToFerrai.share_table_api.entity.enums.FoodStyle> foodStyle = createEnum("foodStyle", com.loadToFerrai.share_table_api.entity.enums.FoodStyle.class);

    public final EnumPath<com.loadToFerrai.share_table_api.entity.enums.SalesStyle> salesStyle = createEnum("salesStyle", com.loadToFerrai.share_table_api.entity.enums.SalesStyle.class);

    public QRestaurantCategory(String variable) {
        super(RestaurantCategory.class, forVariable(variable));
    }

    public QRestaurantCategory(Path<? extends RestaurantCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurantCategory(PathMetadata metadata) {
        super(RestaurantCategory.class, metadata);
    }

}

