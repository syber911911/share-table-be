package com.loadToFerrai.share_table_api.Entity.Embedded;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAgentInfo is a Querydsl query type for UserAgentInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QUserAgentInfo extends BeanPath<UserAgentInfo> {

    private static final long serialVersionUID = -1736469391L;

    public static final QUserAgentInfo userAgentInfo = new QUserAgentInfo("userAgentInfo");

    public final StringPath userAgentId = createString("userAgentId");

    public final EnumPath<com.loadToFerrai.share_table_api.Entity.Enum.UserAgentType> userAgentType = createEnum("userAgentType", com.loadToFerrai.share_table_api.Entity.Enum.UserAgentType.class);

    public QUserAgentInfo(String variable) {
        super(UserAgentInfo.class, forVariable(variable));
    }

    public QUserAgentInfo(Path<? extends UserAgentInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAgentInfo(PathMetadata metadata) {
        super(UserAgentInfo.class, metadata);
    }

}

