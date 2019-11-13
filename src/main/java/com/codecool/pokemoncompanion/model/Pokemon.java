package com.codecool.pokemoncompanion.model;

import java.util.List;

public class Pokemon {

    private int id;
    private List<PokemonType> types;
    private Gender gender;
    private List<PokemonType> weeknesses;
    private int height; //decimetres
    private int weight; //hectograms
    private List<PokemonMove> moves;
}
