package com.codecool.pokemoncompanion;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;


@AllArgsConstructor
@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                .email("user@cc.com")
                .name("user")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user"))
                .roles(Collections.singletonList("ROLE_USER"))
                .myPokemonsList(new ArrayList<>())
                .favouritePokemonsList(new ArrayList<>())
                .myPokemonWishList(new ArrayList<>())
                .banned(true)
                .build();
        userRepository.save(user);

        User admin = User.builder()
                .email("admin@cc.com")
                .name("admin")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"))
                .roles(Collections.singletonList("ROLE_ADMIN"))
                .myPokemonsList(new ArrayList<>())
                .favouritePokemonsList(new ArrayList<>())
                .myPokemonWishList(new ArrayList<>())
                .banned(false)
                .build();
        userRepository.save(admin);
    }
}
