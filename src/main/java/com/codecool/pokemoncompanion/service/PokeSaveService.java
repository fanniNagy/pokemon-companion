package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokeSaveService {

    @Autowired
    private MyPokemonRepository myPokemonRepository;

    @Autowired
    private PokemonCreator pokemonCreator;

    @Autowired
    PokeAPIService pokeAPIService;

    public void addToMyPokemonList(User user, int pokemonId){
        PokemonEntity pokemon = getMyPokemonById(pokemonId);
        user.getMyPokemonsList().add(pokemon);
        myPokemonRepository.save(pokemon);
    }

    private PokemonEntity getMyPokemonById(int id) {
        Pokemon pokemon = pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
