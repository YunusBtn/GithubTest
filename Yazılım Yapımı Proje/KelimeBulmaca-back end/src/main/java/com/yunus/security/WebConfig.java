package com.yunus.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tüm URL'ler için geçerli
                .allowedOrigins("http://localhost:3000") // İzin verilen kaynak (frontend URL)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen HTTP metodları
                .allowedHeaders("*") // İzin verilen header'lar (hepsi izinli)
                .allowCredentials(true); // Tarayıcı çerez kullanımına izin ver (JWT veya oturum yönetimi için gerekebilir)
    }
}