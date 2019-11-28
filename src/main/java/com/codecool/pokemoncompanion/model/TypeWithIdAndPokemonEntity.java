package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Type;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "type")
public class TypeWithIdAndPokemonEntity extends Type {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    PokemonEntity pokemonEntity;

    public TypeWithIdAndPokemonEntity(Type type){
        this.setName(type.getName());
        this.setUrl(type.getUrl());
    }

}

