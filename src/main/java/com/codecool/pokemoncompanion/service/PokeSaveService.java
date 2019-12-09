package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.AbilityWithIdAndPokemonEntity;
import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Ability;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.repository.AbilityRepository;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokeSaveService {

    @Autowired
    private MyPokemonRepository myPokemonRepository;

    @Autowired
    private PokemonCreator pokemonCreator;

    @Autowired
    PokeAPIService pokeAPIService;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    AbilityRepository abilityRepository;

    public void addToMyPokemonList(User user, int pokemonId) {
        PokemonEntity pokemon = getMyPokemonById(pokemonId);
        pokemon.getAbilities().forEach(ability -> ability.getPokemonEntity().add(pokemon));
        pokemon.getTypes().forEach(type -> type.getPokemonEntity().add(pokemon));
        pokemon.getUserPokemons().add(user);
        myPokemonRepository.save(pokemon);
    }

    private PokemonEntity getMyPokemonById(int id) {
        Pokemon pokemon = pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
