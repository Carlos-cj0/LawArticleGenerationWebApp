package com.github.Carlos_cj0.LawArticleGenerationWebApp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Calculates the estimated economic compensation for domestic labor based on
 * Article 1088 of the PRC Civil Code principles and user-provided inputs.
 */
// Consider adding @Component if you want Spring to manage it and inject it elsewhere
// import org.springframework.stereotype.Component;
// @Component
public class DomesticValueCalculator {

    /**
     * Calculates the estimated compensation for domestic labor during a marriage.
     * (Same method content as provided before)
     */
    public double calculateEstimatedCompensation(
            LocalDate marriageStartDate,
            LocalDate marriageEndDate,
            double childcareHoursPerDay,
            double elderlyCareHoursPerDay,
            double housekeepingHoursPerDay,
            double childcareHourlyWage,
            double elderlyCareHourlyWage,
            double housekeepingHourlyWage,
            double opportunityCostTotal) throws IllegalArgumentException {

        // --- Input Validation ---
        validateInputs(marriageStartDate, marriageEndDate, childcareHoursPerDay, elderlyCareHoursPerDay,
                       housekeepingHoursPerDay, childcareHourlyWage, elderlyCareHourlyWage,
                       housekeepingHourlyWage, opportunityCostTotal);

        // --- Calculation Steps ---
        long totalDays = ChronoUnit.DAYS.between(marriageStartDate, marriageEndDate);
        double marriageYears = totalDays / 365.25; // For reference, calculation uses totalDays

        if (marriageYears < 0) marriageYears = 0;

        double dailyDomesticValue = (childcareHoursPerDay * childcareHourlyWage)
                                  + (elderlyCareHoursPerDay * elderlyCareHourlyWage)
                                  + (housekeepingHoursPerDay * housekeepingHourlyWage);

        double totalDomesticValue = dailyDomesticValue * totalDays;

        double estimatedCompensation = totalDomesticValue + opportunityCostTotal;

        return Math.max(0.0, estimatedCompensation);
    }

    /**
     * Validates the inputs for the compensation calculation.
     */
    private void validateInputs(LocalDate startDate, LocalDate endDate, double chHrs, double elHrs, double hkHrs,
                                double chWage, double elWage, double hkWage, double oppCost)
                                throws IllegalArgumentException {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Marriage start and end dates cannot be null.");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Marriage end date cannot be before the start date.");
        }
        if (chHrs < 0 || elHrs < 0 || hkHrs < 0 || chWage < 0 || elWage < 0 || hkWage < 0 || oppCost < 0) {
            throw new IllegalArgumentException("Hours, wages, or opportunity cost cannot be negative.");
        }
        if ((chHrs + elHrs + hkHrs) > 24) {
             System.err.println("Warning: Total calculated daily hours exceed 24. Please verify inputs.");
             // Consider throwing an exception if > 24 is strictly invalid
             // throw new IllegalArgumentException("Total daily hours cannot exceed 24.");
        }
    }
}