package com.cyeproject.questiondiary.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //서버가 응답할 때 json을 자바스크립트에서 처리할 수 있도록 설정합니다 -> 무슨 의미?
        config.addAllowedOrigin("*"); //모든 ip 응답허용
        config.addAllowedHeader("*"); //모든 Header 응답허용
        config.addAllowedMethod("*"); //모든 Http Request Method 응답허용
        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}