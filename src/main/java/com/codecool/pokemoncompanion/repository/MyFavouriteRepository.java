package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyFavouriteRepository extends JpaRepository<PokemonEntity, Long> {
}
