package com.codecool.pokemoncompanion.controller;


import com.codecool.pokemoncompanion.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class FriendController {

    @Autowired
    FriendService friendService;

    @PutMapping("/{userId}/request-friend/{friendId}")
    public void requestFriendship(@PathVariable("userId") Long userid, @PathVariable("friendId") Long friendId) {
        friendService.requestFriendshipByUserID(userid, friendId);
    }

    @PutMapping("/{userId}/accept-friend/{friendId}")
    public void acceptFriendship(@PathVariable("userId") Long userid, @PathVariable("friendId") Long friendId) {
        friendService.acceptFriendship(userid, friendId);
    }
}