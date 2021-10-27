package com.example.parcelnerd;

import com.example.parcelnerd.domain.Package;
import com.example.parcelnerd.domain.PackageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParcelnerdApplication {

    private static final Logger log = LoggerFactory.getLogger(ParcelnerdApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ParcelnerdApplication.class, args);
    }

    @Bean
    public CommandLineRunner packageDemo(PackageRepository repository) {
        return (args) -> {
            log.info("Save a couple of packages");
            repository.save(new Package("Apple iPhone 13 Pro Max 1TB", "13.10.2021", "Pakkamestarinkatu 1D 52, 00500, Helsinki", "James Wand"));
            repository.save(new Package("Sony DualSense Controller White PS5", "21.10.2021", "Hätilänkatu 54, 15610, Lahti", "Ari Paatelainen"));
            repository.save(new Package("Samsung 4K Ultra HD LED TV", "15.10.2021", "Akonmäentie 114, 73900, Rautavaara", "Kimi Viinikka"));
            repository.save(new Package("Apple AirPods Pro earphones", "17.10.2021", "Kerkkolankatu 48, 21380, Aura", "Impi Hasti"));
            log.info("Fetch all packages");
            for (Package package :repository.findAll()) {
                log.info(package.toString());
            }
        };
    }
}