package com.example.parcelnerd;

import com.example.parcelnerd.domain.*;
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
    public CommandLineRunner packageDemo(ParcelRepository repository, UserRepository urepository) {
        return (args) -> {
            log.info("Save a couple of packages");
            repository.save(new Parcel("Apple iPhone 13 Pro Max 1TB", "13.10.2021", "Pakkamestarinkatu 1D 52, 00500, Helsinki", "James Wand", Status.SHIPPED));
            repository.save(new Parcel("Sony DualSense Controller White PS5", "21.10.2021", "Hätilänkatu 54, 15610, Lahti", "Ari Paatelainen", Status.SHIPPING));
            repository.save(new Parcel("Samsung 4K Ultra HD LED TV", "15.10.2021", "Akonmäentie 114, 73900, Rautavaara", "Kimi Viinikka", Status.SHIPPING));
            repository.save(new Parcel("Apple AirPods Pro earphones", "17.10.2021", "Kerkkolankatu 48, 21380, Aura", "Impi Hasti", Status.SHIPPED));

            User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);

            log.info("Fetch all packages");
            for (Parcel parcel :repository.findAll()) {
                log.info(parcel.toString());
            }
        };
    }
}
