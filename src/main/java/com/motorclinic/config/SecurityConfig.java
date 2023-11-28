//package com.motorclinic.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class SecurityConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/motorclinic/api/**") // Ruta de la API que quieres permitir
//                .allowedOrigins("http://localhost:63342") // Origen permitido (tu aplicación frontend)
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
//                .allowedHeaders("*"); // Encabezados permitidos
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
