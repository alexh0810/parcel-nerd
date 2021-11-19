package com.example.parcelnerd;

import com.example.parcelnerd.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ParcelnerdApplication {

    private static final Logger log = LoggerFactory.getLogger(ParcelnerdApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ParcelnerdApplication.class, args);
    }

    @Bean
    public CommandLineRunner packageDemo(ParcelRepository repository, UserRepository urepository) {
        return (args) -> {
        };
    }
}
