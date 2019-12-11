package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.ManagedPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagedPokemonRepositroy extends JpaRepository<ManagedPokemon, Long> {
}
