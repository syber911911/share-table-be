package com.loadToFerrai.share_table_api.common;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private final Environment environment;

    public ProfileApplicationListener(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        String[] activeProfiles = environment.getActiveProfiles();

        for (String profile : activeProfiles) {
            System.out.println("Application started with profile: " + profile);
        }
    }
}
