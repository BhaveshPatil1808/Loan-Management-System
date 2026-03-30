package com.Loan.Service;

public class EMIService {

    public double calculateEMI(double amount, double annualRate, int months) {
        double monthlyRate = annualRate / (12 * 100);

        return (amount * monthlyRate * Math.pow(1 + monthlyRate, months)) /
               (Math.pow(1 + monthlyRate, months) - 1);
    }
}
