package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

    User findFirstByOrderByEmailAsc();

}
