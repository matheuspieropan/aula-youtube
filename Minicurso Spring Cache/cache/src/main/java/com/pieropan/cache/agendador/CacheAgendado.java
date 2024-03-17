package com.pieropan.cache.agendador;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Log4j2
public class CacheAgendado {

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    @CacheEvict("empresas")
    public void limparCacheEmpresas() {
        log.info("Executado: " + LocalDateTime.now());
    }
}