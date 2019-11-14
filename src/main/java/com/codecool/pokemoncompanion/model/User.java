package com.codecool.pokemoncompanion.model;

import java.util.List;

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

}
