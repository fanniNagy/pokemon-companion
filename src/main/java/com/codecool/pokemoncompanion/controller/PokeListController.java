package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.MyPokemon;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/pokemon")
@RestController
public class PokeListController {

    @Autowired
    private PokemonCreator pokemonCreator;

    @Autowired
    private PokeAPIService pokeAPIService;

    @Autowired
    private User user;

    @GetMapping("/")
    public List<ResultsItem> pokes() {
        return pokeAPIService.getPokemons(20, 0);
    }

    @GetMapping("/id/{id}")
    public MyPokemon pokemonByID(@PathVariable("id") int id) {
        return getMyPokemonById(id);
    }

    @GetMapping("/name/{name}")
    public MyPokemon pokemonByName(@PathVariable("name") String name) {
        name = name.toLowerCase();
        Pokemon pokemon =  pokeAPIService.getPokemonByName(name);
        return pokemonCreator.createPokemon(pokemon);
    }

    @PostMapping("/mypokemon/add/{id}")
    public void pokemonToMyPokemonList(@PathVariable("id") int pokemonId){
        user.addToList(user.getMyMyPokemons(), getMyPokemonById(pokemonId));
    }

    @PostMapping("/favourites/add/{id}")
    public void pokemonToMyPokemonFavorite(@PathVariable("id") int pokemonId){
        user.addToList(user.getFavouriteMyPokemons(), getMyPokemonById(pokemonId));
    }

    @PostMapping("/wishlist/add/{id}")
    public void pokemonToMyPokemonWishList(@PathVariable("id") int pokemonId){
        user.addToList(user.getWishList(), getMyPokemonById(pokemonId));
    }

    @GetMapping("/mypokemon/")
    public List<MyPokemon> getMyMyPokemons(){
        return user.getMyMyPokemons();
    }

    @GetMapping("/favourites/")
    public List<MyPokemon> getMyFavourites(){
        return user.getFavouriteMyPokemons();
    }

    @GetMapping("/wishlist/")
    public List<MyPokemon> getMyWishList(){
        return user.getWishList();
    }

    private MyPokemon getMyPokemonById(int id){
        Pokemon pokemon =  pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
