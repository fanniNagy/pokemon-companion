package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.generated.AbilitiesItem;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.TypesItem;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PokemonCreator {

    public PokemonEntity createPokemon(Pokemon pokemon) {
        return new PokemonEntity(
                (long) pokemon.getId(),
                pokemon.getName(),
                pokemon.getTypes().stream().map(TypesItem::getType).collect(Collectors.toList()),
                pokemon.getAbilities().stream().map(AbilitiesItem::getAbility).collect(Collectors.toList()),
                pokemon.getHeight(),
                pokemon.getWeight());
    }

}
