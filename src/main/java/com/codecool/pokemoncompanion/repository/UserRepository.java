package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByOrderByEmailAsc();

    User findByName(String name);

    User findUserById(Long id);
}
