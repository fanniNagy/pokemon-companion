package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

    User findFirstByOrderByEmailAsc();

    User findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.banned = true WHERE u.id = ?1")
    void banUserByUserId(Long id);


    @Query("SELECT u FROM User u WHERE 'ROLE_USER' MEMBER OF u.roles")
    List<User> getNonAdminUsers();
}
