package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    AdminService adminService;

    @PutMapping("/ban/{id}")
    public void banUser(@PathVariable("id") Long userId) {
        adminService.banUserByUserId(userId);
    }
}
