package com.yunus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebMvcConfigurer {

    @Bean
    public org.springframework.web.servlet.config.annotation.WebMvcConfigurer corsConfigurer() {
        return new org.springframework.web.servlet.config.annotation.WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // API altındaki tüm yollara izin ver
                        .allowedOrigins("http://localhost:3002") // Sadece frontend'inizin adresine izin ver
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen HTTP metodları
                        .allowedHeaders("*") // Tüm başlıklara izin ver
                        .allowCredentials(true); // Kimlik bilgileriyle (örn: cookie) isteklere izin ver
            }
        };
    }
}