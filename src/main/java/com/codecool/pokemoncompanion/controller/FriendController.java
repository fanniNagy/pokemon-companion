package com.codecool.pokemoncompanion.controller;


import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import com.codecool.pokemoncompanion.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class FriendController {

    private final UserRepository userRepository;
    private final FriendService friendService;

    @Autowired
    public FriendController(UserRepository userRepository, FriendService friendService) {
        this.userRepository = userRepository;
        this.friendService = friendService;
    }

    @PutMapping("/{userId}/request-friend/{friendId}")
    public void requestFriendship(@PathVariable("userId") Long userid, @PathVariable("friendId") Long friendId) {
        friendService.requestFriendshipByUserID(userid, friendId);
    }

    @CrossOrigin
    @PutMapping("/request-by-name/{userName}/request-friend/{friendName}")
    public void requestFriendship(@PathVariable("userName") String userName, @PathVariable("friendName") String friendName) {
        friendService.requestFriendshipByUserName(userName, friendName);
    }


    @PutMapping("/{userId}/accept-friend/{friendId}")
    public void acceptFriendship(@PathVariable("userId") Long userid, @PathVariable("friendId") Long friendId) {
        friendService.acceptFriendship(userid, friendId);
    }

    @PutMapping("/friend/{userName}/accept-friend/{friendName}")
    public void acceptFriendshipByName(@PathVariable("userName") String userName, @PathVariable("friendName") String friendName){
        friendService.acceptFriendshipByName(userName, friendName);
    }

    @GetMapping("/id/{id}/friends")
    public Set<User> getFriends(@PathVariable("id") Long userid) {
        return userRepository.findFriends(userid);
    }

    @GetMapping("/id/{id}/requests")
    public Set<User> getPendingFriends(@PathVariable("id") Long userId) {
        return userRepository.findPendingFriends(userId);
    }

    @GetMapping("/name/{name}/friends")
    public Set<User> getFriendsByName(@PathVariable("name") String userName) {
        return userRepository.findFriendsByName(userName);
    }

    @GetMapping("/name/{name}/requests")
    public Set<User> getPendingFriends(@PathVariable("name") String userName) {
        return userRepository.findPendingFriendsByName(userName);
    }
}