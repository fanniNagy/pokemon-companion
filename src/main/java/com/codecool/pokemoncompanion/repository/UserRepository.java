package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByOrderByEmailAsc();

    User findByName(String name);

    User findUserById(Long id);

    @Query(value = "select u.friends from User u where u.id = :id")
    Set<User> findFriends(@Param("id") Long id);

    @Query(value = "select u.friends from User u where u.name = :name")
    Set<User> findFriendsByName(@Param("name") String name);

    @Query(value = "select u.friendRequests from User u where u.id = :id")
    Set<User> findPendingFriends(@Param("id") Long id);

    @Query(value = "select u.friendRequests from User u where u.name = :name")
    Set<User> findPendingFriendsByName(@Param("name") String name);

}