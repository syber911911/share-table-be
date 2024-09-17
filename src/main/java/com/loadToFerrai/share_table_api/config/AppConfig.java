package com.loadToFerrai.share_table_api.config;

import com.loadToFerrai.share_table_api.util.WebClient.WebClientUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/properties/AuthorizationProperties.properties")
public class AppConfig {

    @Bean
    JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }

    @Bean
    WebClientUtil webClientUtil(){
        return new WebClientUtil();
    }
}
