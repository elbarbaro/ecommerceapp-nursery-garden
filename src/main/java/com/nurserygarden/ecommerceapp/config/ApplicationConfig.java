package com.nurserygarden.ecommerceapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.nurserygarden.ecommerceapp.repositories"} )
public class ApplicationConfig {
}
