package com.Workshop1.task.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumberController {

    // Home page to input the number
    @GetMapping("/")
    public String home() {
        return "index"; // Returns the index.html template
    }

    // GET method to handle the form submission and generate random numbers
    @GetMapping("/generate")
    public String generateNumbers(@RequestParam("inputNumber") int inputNumber, Model model) {
        // Ensure the inputNumber is within valid range
        if (inputNumber < 1 || inputNumber > 30) {
            model.addAttribute("error", "Please enter a number between 1 and 30.");
            return "index"; // Redirect back to the home page with an error
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        // Keep generating numbers until we have the desired amount
        while (uniqueNumbers.size() < inputNumber) {
            int number = random.nextInt(100) + 1; // Generates numbers between 1 and 100
            uniqueNumbers.add(number); // Set automatically prevents duplicates
        }

        // Convert Set to List and add it to the model
        model.addAttribute("randomNumbers", new ArrayList<>(uniqueNumbers));
        return "generate"; // Return the generate.html template
    }
}