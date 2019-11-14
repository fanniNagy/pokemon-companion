package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.MyPokemon;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pokemon")
@RestController
public class PokeListController {

    @Autowired
    private PokemonCreator pokemonCreator;

    @Autowired
    private PokeAPIService pokeAPIService;

    @Autowired
    private User user;

    @CrossOrigin
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
        Pokemon pokemon =  pokeAPIService.getPokemonByName(name);
        return pokemonCreator.createPokemon(pokemon);
    }

    @PostMapping("/mypokemon/add/{id}")
    public void pokemonToMyPokemonList(@PathVariable("id") int pokemonId){
        user.addToList(user.getMyMyPokemons(), getMyPokemonById(pokemonId));
    }

    private MyPokemon getMyPokemonById(int id){
        Pokemon pokemon =  pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
