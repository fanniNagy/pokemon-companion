package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.*;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import com.codecool.pokemoncompanion.repository.MyPokemonRepository;
import com.codecool.pokemoncompanion.repository.UserRepository;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
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
    UserRepository userRepository;

    @GetMapping("/")
    public List<ResultsItem> pokes() {
        return pokeAPIService.getPokemons(20, 0);
    }

    @GetMapping("/id/{id}")
    public PokemonEntity pokemonByID(@PathVariable("id") int id) {
        /*MyPokemon test = getMyPokemonById(id);
        repository.save(test);                      //db teszt*/
        return getMyPokemonById(id);
    }

    @GetMapping("/name/{name}")
    public PokemonEntity pokemonByName(@PathVariable("name") String name) {
        Pokemon pokemon = pokeAPIService.getPokemonByName(name);
        return pokemonCreator.createPokemon(pokemon);
    }

    @GetMapping("/mypokemon/add/{id}")
    public void pokemonToMyPokemonList(@PathVariable("id") int pokemonId) {
        User user = userRepository.findFirstByOrderByEmailAsc();
        user.getMyPokemonsList().add(getMyPokemonById(pokemonId));
    }

    @GetMapping("/favourites/add/{id}")
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

    private PokemonEntity getMyPokemonById(int id) {
        Pokemon pokemon = pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }

}
