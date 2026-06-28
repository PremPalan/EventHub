package com.ram.tickets;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebugConfig {

    @Bean
    CommandLineRunner debug(EntityManagerFactory emf) {
        return args -> {
            System.out.println("========== Managed Entities ==========");
            emf.getMetamodel().getEntities()
                    .forEach(e -> System.out.println(e.getJavaType()));
            System.out.println("======================================");
        };
    }
}