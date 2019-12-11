package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.ManagedPokemon;
import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.repository.ManagedPokemonRepositroy;
import com.codecool.pokemoncompanion.repository.MyFavouriteRepository;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.repository.MyWishlistRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokeSaveService {

    @Autowired
    private MyPokemonRepository myPokemonRepository;

    @Autowired
    ManagedPokemonCreator managedPokemonCreator;

    @Autowired
    private MyFavouriteRepository favourites;

    @Autowired
    private MyWishlistRepostitory wishlist;

    @Autowired
    private PokemonCreator pokemonCreator;
    @Autowired
    private ManagedPokemonRepositroy managedPokemonRepositroy;

    @Autowired
    private PokeAPIService pokeAPIService;


    public void addToMyPokemonList(User user, int pokemonId) {
        PokemonEntity pokemon = createPokemonForOrm(user, pokemonId);
        myPokemonRepository.save(pokemon);
    }

    public void addToMyWishList(User user, int pokemonId) {
        PokemonEntity pokemon = createPokemonForOrm(user, pokemonId);
        wishlist.save(pokemon);
    }

    public void addToMyFavouriteList(User user, int pokemonId) {
        PokemonEntity pokemon = createPokemonForOrm(user, pokemonId);
        favourites.save(pokemon);
    }

    public void addToManager(Integer cp, Integer quality) {
        ManagedPokemon managedPokemon = managedPokemonCreator.managedPokemonCreator(cp, quality);
        managedPokemonRepositroy.save(managedPokemon);
    }


    private PokemonEntity createPokemonForOrm(User user, int pokemonId) {
        PokemonEntity pokemon = getMyPokemonById(pokemonId);
        pokemon.getAbilities().forEach(ability -> ability.getPokemonEntity().add(pokemon));
        pokemon.getTypes().forEach(type -> type.getPokemonEntity().add(pokemon));
        pokemon.getUserPokemons().add(user);
        return pokemon;
    }

    private PokemonEntity getMyPokemonById(int id) {
        Pokemon pokemon = pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
