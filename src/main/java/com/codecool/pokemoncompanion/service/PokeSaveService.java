package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Ability;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.repository.AbilityRepository;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.repository.TypeRepository;
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

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    AbilityRepository abilityRepository;

    public void addToMyPokemonList(User user, int pokemonId){
        PokemonEntity pokemon = getMyPokemonById(pokemonId);
        user.getMyPokemonsList().add(pokemon);
        myPokemonRepository.save(pokemon);
        pokemon.getAbilities()
                .forEach(ability -> abilityRepository.save(ability));
        pokemon.getTypes()
                .forEach(type -> typeRepository.save(type));
    }

    private PokemonEntity getMyPokemonById(int id) {
        Pokemon pokemon = pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
