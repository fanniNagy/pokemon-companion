package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyWishlistRepostitory extends JpaRepository<PokemonEntity, Long> {
}