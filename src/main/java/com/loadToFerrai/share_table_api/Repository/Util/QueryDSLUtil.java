package com.loadToFerrai.share_table_api.Repository.Util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.function.Supplier;

public class QueryDSLUtil {

    public static BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> nullSafeBuilder) {
        try {
            return new BooleanBuilder(nullSafeBuilder.get());
        } catch (IllegalArgumentException e) {
            return new BooleanBuilder();
        }
    }
}
