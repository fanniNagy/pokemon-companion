package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.TypeWithIdAndPokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeWithIdAndPokemonEntity, Integer> {
}
