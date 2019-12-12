package com.codecool.pokemoncompanion.service;


import com.codecool.pokemoncompanion.model.AbilityWithIdAndPokemonEntity;
import com.codecool.pokemoncompanion.model.ManagedPokemon;
import com.codecool.pokemoncompanion.model.TypeWithIdAndPokemonEntity;
import com.codecool.pokemoncompanion.model.generated.AbilitiesItem;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.TypesItem;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ManagedPokemonCreator {

    public ManagedPokemon managedPokemonCreator(Integer cp, String quality, Pokemon pokemon) {
        return ManagedPokemon.builder()
                .id((long) pokemon.getId())
                .name(pokemon.getName())
                .types(pokemon.getTypes().stream().map(TypesItem::getType).map(TypeWithIdAndPokemonEntity::new).collect(Collectors.toSet()))
                .abilities(pokemon.getAbilities().stream().map(AbilitiesItem::getAbility).map(AbilityWithIdAndPokemonEntity::new).collect(Collectors.toSet()))
                .weight(pokemon.getWeight())
                .height(pokemon.getHeight())
                .cp(cp)
                .quality(quality)
                .build();

    }
}
