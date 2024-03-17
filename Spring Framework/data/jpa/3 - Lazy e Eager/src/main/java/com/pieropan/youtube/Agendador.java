package com.pieropan.youtube;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Agendador {

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    @CacheEvict(value = "addresses", allEntries = true)
    public void agendar() {
    }
}