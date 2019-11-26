package com.codecool.pokemoncompanion;

import com.codecool.pokemoncompanion.model.MyPokemon;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@SpringBootApplication
public class PokemonCompanionApplication {

    @Autowired
    MyPokemonRepository pokemonRepository;

    @Autowired
    User user;

    public static void main(String[] args) {
        SpringApplication.run(PokemonCompanionApplication.class, args);
    }


    public CommandLineRunner init(){
        return args -> {
            MyPokemon pokemon = MyPokemon.builder()
                                                        .id(172)
                                                        .name("pichu");
            user.addToList(user.getMyMyPokemons(), pokemon);
            pokemonRepository.save(pokemon);
        };
    }

}
