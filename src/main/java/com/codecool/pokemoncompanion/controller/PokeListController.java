package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.ManagedPokemon;
import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.wrapper.ResultItemWithId;
import com.codecool.pokemoncompanion.repository.MyFavouriteRepository;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.repository.MyWishlistRepostitory;
import com.codecool.pokemoncompanion.repository.UserRepository;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokeSaveService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/pokemon")
@RestController
public class PokeListController {

    private PokemonCreator pokemonCreator;
    private PokeAPIService pokeAPIService;
    private MyPokemonRepository myPokemonRepository;
    private MyWishlistRepostitory wishlist;
    private MyFavouriteRepository favourites;
    private UserRepository userRepository;
    private PokeSaveService pokeSaveService;

    @Autowired
    public PokeListController(PokemonCreator pokemonCreator, PokeAPIService pokeAPIService, MyPokemonRepository myPokemonRepository, MyWishlistRepostitory wishlist, MyFavouriteRepository favourites, UserRepository userRepository, PokeSaveService pokeSaveService) {
        this.pokemonCreator = pokemonCreator;
        this.pokeAPIService = pokeAPIService;
        this.myPokemonRepository = myPokemonRepository;
        this.wishlist = wishlist;
        this.favourites = favourites;
        this.userRepository = userRepository;
        this.pokeSaveService = pokeSaveService;
    }

    @GetMapping("/")
    public List<ResultItemWithId> pokes() {
        return pokeAPIService.getPokemons(40, 0);
    }


    @GetMapping("/name/{name}")
    public PokemonEntity pokemonByName(@PathVariable("name") String name) {
        name = name.toLowerCase();
        Pokemon pokemon = pokeAPIService.getPokemonByName(name);
        return pokemonCreator.createPokemon(pokemon);
    }

    @PutMapping("/mypokemon/add/{id}")
    public void pokemonToMyPokemonList(@PathVariable("id") int pokemonId) {
        User user = userRepository.findFirstByOrderByEmailAsc();
        pokeSaveService.addToMyPokemonList(user,pokemonId);
    }

    @PutMapping("/favourites/add/{id}")
    public void pokemonToMyPokemonFavorite(@PathVariable("id") int pokemonId) {
        User user = userRepository.findFirstByOrderByEmailAsc();
        pokeSaveService.addToMyFavouriteList(user, pokemonId);
    }

    @PostMapping("/wishlist/add/{id}")
    public void pokemonToMyPokemonWishList(@PathVariable("id") int pokemonId) {
        User user = userRepository.findFirstByOrderByEmailAsc();
        pokeSaveService.addToMyWishList(user, pokemonId);
    }


    @PutMapping("/manager/add/{id}")
    public void addManagedPokemonToManager(@PathVariable("id") int managedPokemonId, @RequestBody String quality) {
        pokeSaveService.addToManager(quality, managedPokemonId);
    }

    @GetMapping("/mypokemon/")
    public List<PokemonEntity> getMyMyPokemons() {
        return null;
    }

    @GetMapping("/favourites/")
    public List<PokemonEntity> getMyFavourites() {
        return null;
    }

    @GetMapping("/wishlist/")
    public List<PokemonEntity> getMyWishList() {
        return null;
    }

    @GetMapping("/manager")
    public List<ManagedPokemon> getManagedPokemons() {
        return null;
    }

}
