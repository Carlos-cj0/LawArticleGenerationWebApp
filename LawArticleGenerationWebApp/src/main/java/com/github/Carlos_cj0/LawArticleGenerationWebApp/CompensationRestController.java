package com.github.Carlos_cj0.LawArticleGenerationWebApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // For sending error status
import org.springframework.http.ResponseEntity; // For sending richer responses
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/compensation")
public class CompensationRestController {

    private static final Logger log = LoggerFactory.getLogger(CompensationRestController.class);

    @Autowired
    private CompensationCalculatorService calculatorService;

    @PostMapping // Endpoint remains the same: POST /api/compensation
    public ResponseEntity<Map<String, Object>> calculate(@RequestBody CompensationRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Call the NEW service method
            double amount = calculatorService.calculateDetailedCompensation(request);
            response.put("success", true);
            response.put("amount", amount);
            log.info("Successfully calculated compensation: {}", amount);
            return ResponseEntity.ok(response); // HTTP 200 OK

        } catch (IllegalArgumentException e) {
            // Handle validation errors (bad dates, negative numbers, etc.)
            log.warn("Calculation failed due to invalid input: {}", e.getMessage());
            response.put("success", false);
            response.put("error", "Invalid input: " + e.getMessage());
            // Return a Bad Request status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // HTTP 400 Bad Request

        } catch (Exception e) {
            // Catch any other unexpected errors during calculation
            log.error("An unexpected error occurred during compensation calculation", e);
            response.put("success", false);
            response.put("error", "An internal error occurred. Please try again later.");
            // Return an Internal Server Error status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // HTTP 500 Internal Server Error
        }
    }
}