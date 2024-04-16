package com.pieropan.youtube.service;

import com.pieropan.youtube.domain.Estado;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class EstadoService {

    public List<Estado> obterEstados() {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";

        ResponseEntity<Estado[]> result = restTemplate.getForEntity(endpoint, Estado[].class);

        Stream<Estado> sorted = Arrays.stream(Objects.requireNonNull(result.getBody()))
                .sorted(Comparator.comparing(Estado::getNome));

        return sorted.toList();
    }
}