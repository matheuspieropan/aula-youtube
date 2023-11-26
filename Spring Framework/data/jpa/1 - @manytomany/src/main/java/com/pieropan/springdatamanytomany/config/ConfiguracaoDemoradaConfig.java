package com.pieropan.springdatamanytomany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class ConfiguracaoDemoradaConfig {

    @Bean
    public ConfiguracaoDemorada configuracaoDemorada() throws InterruptedException {
        return new ConfiguracaoDemorada();
    }

    public static class ConfiguracaoDemorada {
        public ConfiguracaoDemorada() throws InterruptedException {
            Thread.sleep(15000);
        }
    }
}