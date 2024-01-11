package com.pieropan.springwebexemplo.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Objects;

@Configuration
public class InterceptorConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String authorization = httpRequest.getHeader("Authorization");

        if (Objects.nonNull(authorization) && authorization.equals("123")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        throw new RuntimeException("Não foi possível autenticar");
    }
}