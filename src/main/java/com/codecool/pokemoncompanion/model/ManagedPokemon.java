package com.codecool.pokemoncompanion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
public class ManagedPokemon extends PokemonEntity {

    @Id
    Long id;

    String name;
    Integer cp;
    String quality;
    String comment;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TypeWithIdAndPokemonEntity> types = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<AbilityWithIdAndPokemonEntity> abilities = new HashSet<>();

    @ManyToMany
    private Set<User> userManagedPokemons = new HashSet<>();
}
