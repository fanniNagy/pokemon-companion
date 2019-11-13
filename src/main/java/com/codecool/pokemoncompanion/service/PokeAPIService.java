package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.PokemonList;
import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.List;

@Service
public class PokeAPIService {

    public List<ResultsItem> getPokemons(int limit, int pageNumber)  {
        String apiPath = "https://pokeapi.co/api/v2/pokemon/?offset=" + pageNumber + "&limit=" + limit;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PokemonList> responseEntity = restTemplate.exchange(apiPath, HttpMethod.GET, null, PokemonList.class);
        return responseEntity.getBody().getResults();
    }

    public Pokemon getPokemon(int id)  {
        String apiPath = "https://pokeapi.co/api/v2/pokemon/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Pokemon> responseEntity = restTemplate.exchange(apiPath, HttpMethod.GET, null, Pokemon.class);
        return responseEntity.getBody();
    }

}
