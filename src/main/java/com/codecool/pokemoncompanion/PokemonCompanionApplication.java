package com.codecool.pokemoncompanion;


import com.codecool.pokemoncompanion.model.*;
import com.codecool.pokemoncompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class PokemonCompanionApplication {

    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(PokemonCompanionApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            if (userRepository.findAll().size() == 0) {
                User admin = User.builder()
                        .email("admin@cc.com")
                        .id(1L)
                        .name("Admin")
                        .myPokemonsList(new ArrayList<>())
                        .favouritePokemonsList(new ArrayList<>())
                        .myPokemonWishList(new ArrayList<>())
                        .build();
                userRepository.save(admin);
            }

        };
    }

    @Autowired
    public PokemonCompanionApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
