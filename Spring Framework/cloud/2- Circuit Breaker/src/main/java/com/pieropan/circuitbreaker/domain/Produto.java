package com.pieropan.circuitbreaker.domain;

import java.util.List;

public record Produto(String nome, String descricao, List<Double> historicoPrecos) {
}