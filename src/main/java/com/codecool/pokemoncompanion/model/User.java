package com.codecool.pokemoncompanion.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User {
    private int id;
    private String name;
    private String email;
    private List<MyPokemon> myMyPokemons;
    private List<MyPokemon> favouriteMyPokemons;
    private List<MyPokemon> wishList;

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
