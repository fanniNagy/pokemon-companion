package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Ability;
import com.codecool.pokemoncompanion.model.generated.Type;
import com.codecool.pokemoncompanion.model.generated.TypesItem;

import javax.persistence.Entity;
import java.util.List;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
