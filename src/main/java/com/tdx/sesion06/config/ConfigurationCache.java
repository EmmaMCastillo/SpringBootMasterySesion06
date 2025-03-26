package com.tdx.sesion06.config;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ConfigurationCache {

    @Bean
    public Caffeine caffeineConfig(){
        return Caffeine.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES);
    }
}
