package com.codecool.pokemoncompanion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private Integer id;

    private String name;
    private String email;

    @ElementCollection
    private List<MyPokemon> myPokemons = new ArrayList<>();
    @ElementCollection
    private List<MyPokemon> favourites = new ArrayList<>();
    @ElementCollection
    private List<MyPokemon> wishList = new ArrayList<>();


}
