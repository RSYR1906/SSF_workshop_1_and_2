package com.Workshop1.task.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumberController {

    // Home page to input the number
    @GetMapping("/")
    public String home() {
        return "index"; // Returns the index.html template
    }

    // Generate random numbers and display them on the page
    @GetMapping("/generate")
    public String generateNumbers(@RequestParam("inputNumber") int inputNumber, Model model) {
         // Redirect to error page if inputNumber is greater than 10
        if (inputNumber > 10 || inputNumber < 1) {
            model.addAttribute("errorMessage", "Input number cannot be greater than 10.");
            return "error"; // Returns the error.html template
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();
        while (uniqueNumbers.size() < inputNumber) {
            uniqueNumbers.add(random.nextInt(30) + 1);
        }

        model.addAttribute("randomNumbers", new ArrayList<>(uniqueNumbers));
        return "generate";
    }
}