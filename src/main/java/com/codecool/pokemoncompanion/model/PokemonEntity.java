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
import java.util.Objects;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class PokemonEntity {

    @Id
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TypeWithIdAndPokemonEntity> types = new HashSet<>();

    @ManyToMany
    private Set<User> userPokemons = new HashSet<>();
    @ManyToMany
    private Set<User> userWishListPokemons = new HashSet<>();
    @ManyToMany
    private Set<User> userFavPokemons = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
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
