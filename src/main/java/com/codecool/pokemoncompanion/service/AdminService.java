package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    UserRepository userRepository;

    public void banUserByUserId(Long userId) {
        userRepository.banUserByUserId(userId);
    }
}
