package org.samsung.Refactor;

public class PremiumStrategy implements  InterestStrategy {
    public  double calculateRate(int months) {
        double interestRate;
        if (months < 6) {
            interestRate = 0.05;
        } else if (months < 12) {
            interestRate = 0.065;
        } else {
            interestRate = 0.08;
        }
        return  interestRate;
    }
}
