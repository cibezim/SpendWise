package com.spendwise.spendwiseapp.dto;


public class ExpenseDTO {

    private String description;
    private double amount;

    // Constructors, getters, and setters
    public ExpenseDTO() {
    }

    public ExpenseDTO(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
