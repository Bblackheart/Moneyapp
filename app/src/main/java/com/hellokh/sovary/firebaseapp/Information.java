package com.hellokh.sovary.firebaseapp;

public class Information {

    private String expenses;
    private String revenue;

    public Information() {
    }

    public Information(String expenses, String revenue) {
        this.expenses = expenses;
        this.revenue = revenue;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }
}
