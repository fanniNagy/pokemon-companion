package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Ability;
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
public class AbilityWithIdAndPokemonEntity extends Ability {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    PokemonEntity pokemonEntity;

    private String name;

    public AbilityWithIdAndPokemonEntity(Ability ability){
        this.setName(ability.getName());
        this.setUrl(ability.getUrl());
    }
}
