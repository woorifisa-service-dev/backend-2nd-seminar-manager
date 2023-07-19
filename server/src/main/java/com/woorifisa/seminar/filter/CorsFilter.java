package com.woorifisa.seminar.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsFilter implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    // "http://localhost:3000",
                    // "http://localhost:5173",
                    // "http://127.0.0.1:5173",
                    // "http://192.168.0.170:5173",
                    // "http://192.168.0.188:5173",
                    // "http://118.131.63.237:5173"
                    "http://43.201.51.101"
                ) // 허용할 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3000);
    }

}
