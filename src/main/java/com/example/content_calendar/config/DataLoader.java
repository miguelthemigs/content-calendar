package com.example.content_calendar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Interface used to indicate that a bean should run when it is contained within a SpringApplication.
// @Component
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello 🔥");
    }
}
