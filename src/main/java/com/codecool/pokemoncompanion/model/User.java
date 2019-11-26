package com.codecool.pokemoncompanion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;     //legyen Integer?

    private String name;
    private String email;
    @ElementCollection
    private List<MyPokemon> myMyPokemons = new ArrayList<>();
    @ElementCollection
    private List<MyPokemon> favouriteMyPokemons = new ArrayList<>();
    @ElementCollection
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
