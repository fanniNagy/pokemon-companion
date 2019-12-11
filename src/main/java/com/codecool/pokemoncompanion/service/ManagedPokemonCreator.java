package com.codecool.pokemoncompanion.service;


import com.codecool.pokemoncompanion.model.ManagedPokemon;
import org.springframework.stereotype.Service;

@Service
public class ManagedPokemonCreator {

    public ManagedPokemon managedPokemonCreator(Integer cp, Integer quality) {
        return ManagedPokemon.builder()
                .cp(cp)
                .quality(quality)
                .build();

    }
}
