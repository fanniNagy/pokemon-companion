package com.codecool.pokemoncompanion.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToMany(mappedBy = "userPokemons")
    private List<PokemonEntity> myPokemonsList;

    @ManyToMany(mappedBy = "userFavPokemons")
    private List<PokemonEntity> favouritePokemonsList;

    @ManyToMany(mappedBy = "userWishListPokemons")
    private List<PokemonEntity> myPokemonWishList;

}
