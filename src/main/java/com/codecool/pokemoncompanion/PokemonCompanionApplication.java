package com.codecool.pokemoncompanion;


import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PokemonCompanionApplication {

    @Autowired
    PokeAPIService pokeAPIService;

    @Autowired
    MyPokemonRepository pokemonRepository;

    @Autowired
    PokemonCreator creator;

    public static void main(String[] args) {
        SpringApplication.run(PokemonCompanionApplication.class, args);
    }
/*
    public CommandLineRunner init() {
        Pokemon pokemon = pokeAPIService.getPokemonByID(172);
        return (CommandLineRunner) pokemonRepository.save(creator.createPokemon(pokemon));
    }*/


}
