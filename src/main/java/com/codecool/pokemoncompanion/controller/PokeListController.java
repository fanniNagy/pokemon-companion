package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.*;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.repository.UserRepository;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
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
    MyPokemonRepository repository;

    @Autowired
    User user;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<ResultsItem> pokes() {
        return pokeAPIService.getPokemons(20, 0);
    }

    @GetMapping("/id/{id}")
    public MyPokemon pokemonByID(@PathVariable("id") int id) {
        /*MyPokemon test = getMyPokemonById(id);
        repository.save(test);                      //db teszt*/
        return getMyPokemonById(id);
    }

    @GetMapping("/name/{name}")
    public MyPokemon pokemonByName(@PathVariable("name") String name) {
        Pokemon pokemon = pokeAPIService.getPokemonByName(name);
        return pokemonCreator.createPokemon(pokemon);
    }

    @GetMapping("/mypokemon/add/{id}")
    public void pokemonToMyPokemonList(@PathVariable("id") int pokemonId) {

    }

    @GetMapping("/favourites/add/{id}")
    public void pokemonToMyPokemonFavorite(@PathVariable("id") int pokemonId) {
    }

    @PostMapping("/wishlist/add/{id}")
    public void pokemonToMyPokemonWishList(@PathVariable("id") int pokemonId) {
    }

    @GetMapping("/mypokemon/")
    public List<MyPokemon> getMyMyPokemons() {
        return user.getMyPokemons();
    }

    @GetMapping("/favourites/")
    public List<MyPokemon> getMyFavourites() {
        return user.getFavourites();
    }

    @GetMapping("/wishlist/")
    public List<MyPokemon> getMyWishList() {
        return user.getWishList();
    }

    private MyPokemon getMyPokemonById(int id) {
        Pokemon pokemon = pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
