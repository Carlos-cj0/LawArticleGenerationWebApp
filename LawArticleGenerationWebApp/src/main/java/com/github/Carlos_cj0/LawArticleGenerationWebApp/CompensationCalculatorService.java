package com.github.Carlos_cj0.LawArticleGenerationWebApp;

import org.slf4j.Logger; // Use SLF4J for logging - good practice
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
// Removed Autowired as we'll instantiate calculator directly for simplicity,
// but could use @Autowired if DomesticValueCalculator is marked @Component
// import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class CompensationCalculatorService {

    private static final Logger log = LoggerFactory.getLogger(CompensationCalculatorService.class);

    // Instantiate directly, or use @Autowired if DomesticValueCalculator is a @Component
    private final DomesticValueCalculator domesticValueCalculator = new DomesticValueCalculator();

    // @Autowired // Uncomment if DomesticValueCalculator becomes a @Component
    // private DomesticValueCalculator domesticValueCalculator;

    /**
     * Calculates compensation using the detailed domestic value calculator.
     *
     * @param request The updated CompensationRequest with detailed fields.
     * @return The calculated compensation amount.
     * @throws IllegalArgumentException if inputs are invalid (e.g., bad date format, validation errors from calculator).
     */
    public double calculateDetailedCompensation(CompensationRequest request) throws IllegalArgumentException {
        log.info("Received compensation request: {}", request); // Use logging

        LocalDate startDate;
        LocalDate endDate;

        // --- Parse Dates ---
        try {
            startDate = LocalDate.parse(request.getMarriageStartDate()); // Assumes "YYYY-MM-DD"
            endDate = LocalDate.parse(request.getMarriageEndDate());     // Assumes "YYYY-MM-DD"
        } catch (DateTimeParseException | NullPointerException e) {
            log.error("Invalid date format received. StartDate: {}, EndDate: {}",
                      request.getMarriageStartDate(), request.getMarriageEndDate(), e);
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD.", e);
        }

        // --- Call the Detailed Calculator ---
        try {
            double result = domesticValueCalculator.calculateEstimatedCompensation(
                    startDate,
                    endDate,
                    request.getChildcareHoursPerDay(),
                    request.getElderlyCareHoursPerDay(),
                    request.getHousekeepingHoursPerDay(),
                    request.getChildcareHourlyWage(),
                    request.getElderlyCareHourlyWage(),
                    request.getHousekeepingHourlyWage(),
                    request.getOpportunityCostTotal()
            );
            log.info("Calculation successful. Result: {}", result);
            return result;
        } catch (IllegalArgumentException e) {
            // Log the specific validation error from the calculator
            log.error("Calculation validation failed: {}", e.getMessage());
            // Re-throw the specific exception to be potentially handled by the controller/advice
            throw e;
        }
    }
}