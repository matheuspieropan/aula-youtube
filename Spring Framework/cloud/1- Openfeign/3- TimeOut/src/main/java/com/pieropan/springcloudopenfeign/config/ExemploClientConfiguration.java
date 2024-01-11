package com.pieropan.springcloudopenfeign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ExemploClientConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "123");
    }
}