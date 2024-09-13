package com.loadToFerrai.share_table_api.Entity.Embedded;

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

    private static final long serialVersionUID = 1537861202L;

    public static final QRestaurantCategory restaurantCategory = new QRestaurantCategory("restaurantCategory");

    public final StringPath foodStyle = createString("foodStyle");

    public final StringPath salesStyle = createString("salesStyle");

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

