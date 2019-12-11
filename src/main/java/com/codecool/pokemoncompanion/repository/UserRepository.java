package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long> {

    User findFirstByOrderByEmailAsc();

    User findByName(String name);

    @Query("UPDATE User SET banned = true WHERE User.id = ?1")
    void banUserByUserId(Long id);
}
