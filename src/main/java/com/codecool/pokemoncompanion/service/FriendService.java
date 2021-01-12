package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FriendService {

    private final UserRepository userRepository;

    @Autowired
    public FriendService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void persistFriendRequestIfNotExist(User user, User requestedFriend) {
        if (!requestedFriend.getFriendRequests().contains(user)) {
            requestedFriend.getFriendRequests().add(user);
            userRepository.saveAndFlush(requestedFriend);
        }
    }

    private void persistFriendshipIfNotExist(User user, User friend) {
        friend.friendRequests.remove(user);
        user.friendRequests.remove(friend);
        user.friends.add(friend);
        friend.friends.add(user);
        userRepository.saveAndFlush(friend);
        userRepository.saveAndFlush(user);
    }

    public void requestFriendshipByUserID(Long userid, Long friendId) {
        User user = userRepository.findUserById(userid);
        User requestedFriend = userRepository.findUserById(friendId);
        persistFriendRequestIfNotExist(user, requestedFriend);
    }

    public void acceptFriendship(Long userid, Long friendId) {
        User user = userRepository.findUserById(userid);
        User friend = userRepository.findUserById(friendId);
        persistFriendshipIfNotExist(user, friend);
    }

    public void requestFriendshipByUserName(String userName, String friendName) {
        User user = userRepository.findByName(userName);
        if (userRepository.findByName(friendName) == null) {
            throw new NoSuchElementException("no such user found!");
        } else {
            User requestedFriend = userRepository.findByName(friendName);
            persistFriendRequestIfNotExist(user, requestedFriend);
        }
    }

    public void acceptFriendshipByName(String userName, String friendName) {
        User user = userRepository.findByName(userName);
        User friend = userRepository.findByName(friendName);
        persistFriendshipIfNotExist(user, friend);
    }
}
