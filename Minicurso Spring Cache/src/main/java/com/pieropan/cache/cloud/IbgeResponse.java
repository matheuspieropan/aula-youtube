package com.pieropan.cache.cloud;

import java.io.Serializable;

public record IbgeResponse(int id, String nome) implements Serializable {
}