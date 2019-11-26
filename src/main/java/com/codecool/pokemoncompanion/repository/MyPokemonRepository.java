package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.MyPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPokemonRepository extends JpaRepository<MyPokemon, Integer> {
}
