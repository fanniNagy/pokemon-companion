package com.codecool.pokemoncompanion.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String name;
    private String email;


    @ManyToMany(mappedBy = "userPokemons", cascade = CascadeType.ALL)
    private List<PokemonEntity> myPokemonsList;

    @ManyToMany(mappedBy = "userFavPokemons", cascade = CascadeType.ALL)
    private List<PokemonEntity> favouritePokemonsList;

    @ManyToMany(mappedBy = "userWishListPokemons", cascade = CascadeType.ALL)
    private List<PokemonEntity> myPokemonWishList;

}
