package com.testmin.jwtserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true); // 내 서버가 응답을 할 때 json 을 자바스크립트에서 처리할 수 있게 할지를 설정
        corsConfiguration.addAllowedOrigin("*"); // 모든 IP에 응답을 허용
        corsConfiguration.addAllowedHeader("*"); // 모든 header 에 응답을 허용
        corsConfiguration.addAllowedMethod("*"); // GET, POST, PUT, DELETE, PATCH 등 모든 HttpMethod 허용
        source.registerCorsConfiguration("/api/**", corsConfiguration);

        return new CorsFilter(source);
    }
}
