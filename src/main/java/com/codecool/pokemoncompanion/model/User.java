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
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id = 1;

    private String name = "Admin";
    private String email = "admin@cc.com";

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<MyPokemon> myPokemons = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    private List<MyPokemon> favourites = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    private List<MyPokemon> wishList = new ArrayList<>();


}
