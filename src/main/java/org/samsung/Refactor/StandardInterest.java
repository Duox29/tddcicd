package org.samsung.Refactor;

public class StandardInterest implements InterestStrategy {
    @Override
    public double calculateRate(int months) {
        double interestRate;
        if (months < 6) {
            interestRate = 0.03;
        } else if (months < 12) {
            interestRate = 0.045;
        } else {
            interestRate = 0.06;
        }
        return interestRate;
    }
}
