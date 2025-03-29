package com.github.Carlos_cj0.LawArticleGenerationWebApp;



import org.springframework.stereotype.Service;

@Service
public class CompensationCalculatorService {

    public double calculateCompensation(CompensationRequest request) {
        // static value calculation logic: (to be adjusted later)
        double baseRatePerHour = 25.0; // Static assumed rate
        double annualValue = request.getDailyHouseworkHours() * baseRatePerHour * 365;
        return annualValue * request.getMarriageYears();
    }
}