package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.IVValues;
import com.codecool.pokemoncompanion.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;


    @PostMapping("/ivcalculator")
    public String sendIvValue(@RequestBody IVValues ivValues) {
        String result = calculatorService.calculateIV(ivValues.getHp(), ivValues.getAttack(), ivValues.getDefense());
        return result;
    }

}
