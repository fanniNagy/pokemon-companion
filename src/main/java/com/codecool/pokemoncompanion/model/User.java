package com.codecool.pokemoncompanion.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class User {
    private int id;
    private String name;
    private String email;
    private List<MyPokemon> myMyPokemons = new ArrayList<>();
    private List<MyPokemon> favouriteMyPokemons = new ArrayList<>();
    private List<MyPokemon> wishList = new ArrayList<>();

    public void addToList(List list, MyPokemon myPokemon) {
        list.add(myPokemon);
    }

    public void removeFroList(List list, MyPokemon myPokemon) {
        list.remove(myPokemon);
    }

    public List<MyPokemon> getMyMyPokemons() {
        return myMyPokemons;
    }

    public List<MyPokemon> getFavouriteMyPokemons() {
        return favouriteMyPokemons;
    }

    public List<MyPokemon> getWishList() {
        return wishList;
    }
}
