package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.*;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.wrapper.ResultItemWithId;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
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
    private UserRepository userRepository;
    private PokeSaveService pokeSaveService;

    @Autowired
    public PokeListController(PokemonCreator pokemonCreator, PokeAPIService pokeAPIService, MyPokemonRepository myPokemonRepository, UserRepository userRepository, PokeSaveService pokeSaveService) {
        this.pokemonCreator = pokemonCreator;
        this.pokeAPIService = pokeAPIService;
        this.myPokemonRepository = myPokemonRepository;
        this.userRepository = userRepository;
        this.pokeSaveService = pokeSaveService;
    }

    @GetMapping("/")
    public List<ResultItemWithId> pokes() {
        return pokeAPIService.getPokemons(900, 0);
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
    }

    @PostMapping("/wishlist/add/{id}")
    public void pokemonToMyPokemonWishList(@PathVariable("id") int pokemonId) {
    }

    @GetMapping("/mypokemon/")
    public List<PokemonEntity> getMyMyPokemons() {
        User user = userRepository.findFirstByOrderByEmailAsc();
        return user.getMyPokemonsList();
    }

    @GetMapping("/favourites/")
    public List<PokemonEntity> getMyFavourites() {
        User user = userRepository.findFirstByOrderByEmailAsc();
        return user.getFavouritePokemonsList();
    }

    @GetMapping("/wishlist/")
    public List<PokemonEntity> getMyWishList() {
        User user = userRepository.findFirstByOrderByEmailAsc();
        return user.getMyPokemonWishList();
    }

}
