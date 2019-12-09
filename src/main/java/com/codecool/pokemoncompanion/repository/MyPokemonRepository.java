package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface MyPokemonRepository extends JpaRepository<PokemonEntity, Long> {

}
