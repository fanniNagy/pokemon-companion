package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Ability;
import com.codecool.pokemoncompanion.model.generated.Type;
import com.codecool.pokemoncompanion.model.generated.TypesItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


@Data
@NoArgsConstructor
@Builder
@Entity
public class MyPokemon {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    @ElementCollection
    private List<Type> types;
    @ElementCollection
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
