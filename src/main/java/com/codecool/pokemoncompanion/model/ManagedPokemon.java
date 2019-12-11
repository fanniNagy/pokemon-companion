package com.codecool.pokemoncompanion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
public class ManagedPokemon extends PokemonEntity {

    Integer cp;
    Integer quality;

    @ManyToMany
    private Set<User> userManagedPokemons = new HashSet<>();
}
