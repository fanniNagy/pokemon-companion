package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TypeWithIdAndPokemonEntity extends Type {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    PokemonEntity pokemonEntity;

    private String name;

    public TypeWithIdAndPokemonEntity(Type type){
        this.setName(type.getName());
        this.setUrl(type.getUrl());
    }

}

