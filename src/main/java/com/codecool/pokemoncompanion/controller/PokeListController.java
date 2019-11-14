package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.MyPokemon;
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


    @CrossOrigin
    @GetMapping("/")
    public List<ResultsItem> pokes() {
        return pokeAPIService.getPokemons(20, 1);
    }
//
//    @GetMapping("/poke/{id}")
//    public Pokemon poke(@PathVariable("id") int id) {
//        return pokeAPIService.getPokemonByID(id);
//    }

    @GetMapping("/id/{id}")
    public MyPokemon pokemonByID(@PathVariable("id") int id) {
        Pokemon pokemon =  pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }

    @GetMapping("/name/{name}")
    public MyPokemon pokemonByName(@PathVariable("name") String name) {
        Pokemon pokemon =  pokeAPIService.getPokemonByName(name);
        return pokemonCreator.createPokemon(pokemon);
    }


}
