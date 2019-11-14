package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.MyPokemon;
import com.codecool.pokemoncompanion.model.generated.AbilitiesItem;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.TypesItem;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PokemonCreator {

    public MyPokemon createPokemon(Pokemon pokemon) {
        return new MyPokemon(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getTypes().stream().map(TypesItem::getType).collect(Collectors.toList()),
                pokemon.getAbilities().stream().map(AbilitiesItem::getAbility).collect(Collectors.toList()),
                pokemon.getHeight(),
                pokemon.getWeight());
    }

}
