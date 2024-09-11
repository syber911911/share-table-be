package com.loadToFerrai.share_table_api.config;

import com.loadToFerrai.share_table_api.WebClient.WebClientUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/properties/AuthorizationProperties.properties")
public class AppConfig {

    @Bean
    WebClientUtil webClientUtil(){
        return new WebClientUtil();
    }
}
