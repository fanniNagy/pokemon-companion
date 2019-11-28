package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Ability;
import com.codecool.pokemoncompanion.model.generated.Type;
import com.codecool.pokemoncompanion.model.generated.TypesItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Component
@Entity
public class PokemonEntity {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "pokemonEntity")
    private List<TypeWithIdAndPokemonEntity> types;

    @ManyToMany
    private List<User> userPokemons = new ArrayList<>();
    @ManyToMany
    private List<User> userWishListPokemons;
    @ManyToMany
    private List<User> userFavPokemons;

    @OneToMany(mappedBy = "pokemonEntity")
    private List<AbilityWithIdAndPokemonEntity> abilities;

    private int height;         //decimetres
    private int weight;        //hectograms

    public PokemonEntity(Long id, String name, List<TypeWithIdAndPokemonEntity> types,
                         List<AbilityWithIdAndPokemonEntity> abilities, int height, int weight) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.height = height;
        this.weight = weight;
    }

}
