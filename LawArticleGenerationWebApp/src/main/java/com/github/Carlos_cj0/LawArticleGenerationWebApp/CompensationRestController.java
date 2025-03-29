package com.github.Carlos_cj0.LawArticleGenerationWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/compensation")
public class CompensationRestController {

    @Autowired
    private CompensationCalculatorService calculatorService;

    @PostMapping
    public Map<String, Double> calculate(@RequestBody CompensationRequest request) {
        double amount = calculatorService.calculateCompensation(request);
        Map<String, Double> response = new HashMap<>();
        response.put("amount", amount);
        return response;
    }
}