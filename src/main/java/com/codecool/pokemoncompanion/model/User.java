package com.codecool.pokemoncompanion.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;

    @Singular
    @OneToMany(mappedBy = "user")
    private List<MyPokemon> myPokemons = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    @Singular
    private List<MyPokemon> favourites = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    @Singular
    private List<MyPokemon> wishList = new ArrayList<>();


}
