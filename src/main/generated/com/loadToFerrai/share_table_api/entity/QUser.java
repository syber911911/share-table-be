package com.loadToFerrai.share_table_api.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 938185816L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.loadToFerrai.share_table_api.entity.embedded.QUserAgentInfo userAgentInfo;

    public final StringPath userAgeRange = createString("userAgeRange");

    public final EnumPath<com.loadToFerrai.share_table_api.entity.enums.UserAuthorityType> userAuthorityType = createEnum("userAuthorityType", com.loadToFerrai.share_table_api.entity.enums.UserAuthorityType.class);

    public final StringPath userEmailAddress = createString("userEmailAddress");

    public final EnumPath<com.loadToFerrai.share_table_api.entity.enums.Gender> userGender = createEnum("userGender", com.loadToFerrai.share_table_api.entity.enums.Gender.class);

    public final StringPath userName = createString("userName");

    public final StringPath userProfileIMG = createString("userProfileIMG");

    public final StringPath userProfileNickname = createString("userProfileNickname");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userAgentInfo = inits.isInitialized("userAgentInfo") ? new com.loadToFerrai.share_table_api.entity.embedded.QUserAgentInfo(forProperty("userAgentInfo")) : null;
    }

}

