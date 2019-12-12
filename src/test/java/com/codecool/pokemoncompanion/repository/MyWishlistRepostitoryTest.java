package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ExtendWith(SpringExtension.class)
class MyWishlistRepostitoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    MyWishlistRepostitory myWishlistRepostitory;

    @Autowired
    UserRepository userRepository;

    @Test
    public void myWishListSaveTest() {
        User user = getUser();
        testEntityManager.persist(user);

        PokemonEntity testPokemonEntity = getPokemonEntity(user);
        testEntityManager.persist(testPokemonEntity);

        List<PokemonEntity> testResult = myWishlistRepostitory.findAll();
        assertNotNull(testPokemonEntity);
        assertTrue(testResult.contains(testPokemonEntity));
        assertEquals(testResult.get(0).getUserWishListPokemons(), testPokemonEntity.getUserWishListPokemons());
    }


    private PokemonEntity getPokemonEntity(User user) {
        Set<User> wishPokemonUser = new HashSet<>();
        wishPokemonUser.add(user);
        return PokemonEntity.builder()
                .name("test")
                .id(1l)
                .userWishListPokemons(wishPokemonUser)
                .build();
    }

    private User getUser() {
        return User.builder()
                .email("test@cc.com")
                .name("test")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("test"))
                .roles(Collections.singletonList("ROLE_TEST"))
                .build();

    }
}