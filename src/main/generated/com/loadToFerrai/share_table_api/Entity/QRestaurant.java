package com.loadToFerrai.share_table_api.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = 1535366634L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final com.loadToFerrai.share_table_api.Entity.Embedded.QAddress address;

    public final NumberPath<Integer> avgRatings = createNumber("avgRatings", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> deletedAt = createDateTime("deletedAt", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final NumberPath<Double> let = createNumber("let", Double.class);

    public final NumberPath<Double> lon = createNumber("lon", Double.class);

    public final StringPath menuInfo = createString("menuInfo");

    public final DateTimePath<java.sql.Timestamp> modifiedAt = createDateTime("modifiedAt", java.sql.Timestamp.class);

    public final StringPath name = createString("name");

    public final com.loadToFerrai.share_table_api.Entity.Embedded.QRestaurantCategory restaurantCategory;

    public final StringPath runtime = createString("runtime");

    public final StringPath tel = createString("tel");

    public QRestaurant(String variable) {
        this(Restaurant.class, forVariable(variable), INITS);
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurant(PathMetadata metadata, PathInits inits) {
        this(Restaurant.class, metadata, inits);
    }

    public QRestaurant(Class<? extends Restaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.loadToFerrai.share_table_api.Entity.Embedded.QAddress(forProperty("address")) : null;
        this.restaurantCategory = inits.isInitialized("restaurantCategory") ? new com.loadToFerrai.share_table_api.Entity.Embedded.QRestaurantCategory(forProperty("restaurantCategory")) : null;
    }

}

