package com.codecool.pokemoncompanion.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@Component
@Entity
public class PokemonEntity {

    @Id
    private Long id;

    private String name;

    @ManyToMany
    private Set<TypeWithIdAndPokemonEntity> types = new HashSet<>();

    @ManyToMany
    private Set<User> userPokemons = new HashSet<>();
    @ManyToMany
    private Set<User> userWishListPokemons = new HashSet<>();
    @ManyToMany
    private Set<User> userFavPokemons = new HashSet<>();


    @ManyToMany
    private Set<AbilityWithIdAndPokemonEntity> abilities = new HashSet<>();

    private int height;         //decimetres
    private int weight;        //hectograms


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonEntity that = (PokemonEntity) o;
        return id.equals(that.id) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public PokemonEntity(Long id, String name, Set<TypeWithIdAndPokemonEntity> types,
                         Set<AbilityWithIdAndPokemonEntity> abilities, int height, int weight) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.height = height;
        this.weight = weight;
    }

}
