package com.github.Carlos_cj0.LawArticleGenerationWebApp;



public class CompensationRequest {


    private String marriageStartDate; // Format like "YYYY-MM-DD" from HTML date input
    private String marriageEndDate;   // Format like "YYYY-MM-DD" from HTML date input

    private double childcareHoursPerDay;
    private double elderlyCareHoursPerDay;
    private double housekeepingHoursPerDay;

    private double childcareHourlyWage;
    private double elderlyCareHourlyWage;
    private double housekeepingHourlyWage;

    private double opportunityCostTotal;

    // Getters and Setters for all fields 

    public String getMarriageStartDate() {
        return marriageStartDate;
    }

    public void setMarriageStartDate(String marriageStartDate) {
        this.marriageStartDate = marriageStartDate;
    }

    public String getMarriageEndDate() {
        return marriageEndDate;
    }

    public void setMarriageEndDate(String marriageEndDate) {
        this.marriageEndDate = marriageEndDate;
    }

    public double getChildcareHoursPerDay() {
        return childcareHoursPerDay;
    }

    public void setChildcareHoursPerDay(double childcareHoursPerDay) {
        this.childcareHoursPerDay = childcareHoursPerDay;
    }

    public double getElderlyCareHoursPerDay() {
        return elderlyCareHoursPerDay;
    }

    public void setElderlyCareHoursPerDay(double elderlyCareHoursPerDay) {
        this.elderlyCareHoursPerDay = elderlyCareHoursPerDay;
    }

    public double getHousekeepingHoursPerDay() {
        return housekeepingHoursPerDay;
    }

    public void setHousekeepingHoursPerDay(double housekeepingHoursPerDay) {
        this.housekeepingHoursPerDay = housekeepingHoursPerDay;
    }

    public double getChildcareHourlyWage() {
        return childcareHourlyWage;
    }

    public void setChildcareHourlyWage(double childcareHourlyWage) {
        this.childcareHourlyWage = childcareHourlyWage;
    }

    public double getElderlyCareHourlyWage() {
        return elderlyCareHourlyWage;
    }

    public void setElderlyCareHourlyWage(double elderlyCareHourlyWage) {
        this.elderlyCareHourlyWage = elderlyCareHourlyWage;
    }

    public double getHousekeepingHourlyWage() {
        return housekeepingHourlyWage;
    }

    public void setHousekeepingHourlyWage(double housekeepingHourlyWage) {
        this.housekeepingHourlyWage = housekeepingHourlyWage;
    }

    public double getOpportunityCostTotal() {
        return opportunityCostTotal;
    }

    public void setOpportunityCostTotal(double opportunityCostTotal) {
        this.opportunityCostTotal = opportunityCostTotal;
    }
}