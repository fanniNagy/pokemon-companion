package com.codecool.pokemoncompanion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    private String email;
    @NotNull
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @ManyToMany
    public Set<User> friends = new HashSet<>();

    @OneToMany
    public Set<User> friendRequests = new HashSet<>();

    public void requestFriendship(User user) {
        user.friendRequests.add(this);
    }

    public void confirmFriends(User user) {
        this.friendRequests.remove(user);
        user.friends.add(this);
        this.friends.add(user);
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
