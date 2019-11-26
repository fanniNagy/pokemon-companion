package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Ability;
import com.codecool.pokemoncompanion.model.generated.Type;
import com.codecool.pokemoncompanion.model.generated.TypesItem;
import lombok.Data;

import java.util.List;

@Data
public class MyPokemon {

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private List<Type> types;
    private List<Ability> abilities;
    private int height; //decimetres
    private int weight; //hectograms

    public MyPokemon(int id, String name, List<Type> types, List<Ability> abilities, int height, int weight) {
        this.id = id;
        this.name= name;
        this.types = types;
        this.abilities = abilities;
        this.height = height;
        this.weight = weight;
    }

}
