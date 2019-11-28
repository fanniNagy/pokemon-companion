package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.AbilityWithIdAndPokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<AbilityWithIdAndPokemonEntity, Integer> {
}
