package com.codecool.pokemoncompanion;


import com.codecool.pokemoncompanion.model.MyPokemon;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.repository.UserRepository;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class PokemonCompanionApplication {

    @Autowired
    PokeAPIService pokeAPIService;

    @Autowired
    MyPokemonRepository pokemonRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PokemonCreator creator;

    public static void main(String[] args) {
        SpringApplication.run(PokemonCompanionApplication.class, args);
    }
    public CommandLineRunner init() {
        return args -> {
            List<MyPokemon> myPokemons = new ArrayList<>();
            List<MyPokemon> fav = new ArrayList<>();
            List<MyPokemon> wish = new ArrayList<>();
            if (userRepository.findAll().equals(0)){
                User.builder()
                        .email("admin@cc.com")
                        .id(1)
                        .name("Admin")
                        .myPokemons(myPokemons)
                        .favourites(fav)
                        .wishList(wish)
                        .build();
            }

        };
    }


}
