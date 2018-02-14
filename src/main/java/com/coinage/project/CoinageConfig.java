package com.coinage.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoinageConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
