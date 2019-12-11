package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pokemon")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;


    @PostMapping("/ivcalculator")
    public ResponseEntity sendIvValue(@RequestParam("hp") Integer hp, @RequestParam("attack") Integer attack, @RequestParam("defense") Integer defense) {
        return ResponseEntity.ok().body(calculatorService.calculateIV(hp, attack, defense));
    }

}
