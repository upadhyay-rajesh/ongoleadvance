package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
//	@SuppressWarnings("deprecation")
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                .allowedHeaders("Access-control-Allow-Origin")
//                .allowedHeaders("Access-Control-Allow-Headers")
//                .allowedHeaders("Access-Control-Allow-Credentials")
//                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
//                .allowedOrigins("*");
//            }
//        };
//    }

}
