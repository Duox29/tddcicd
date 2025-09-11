package org.samsung.Refactor;

public class VipStrategy implements  InterestStrategy {
    public  double calculateRate(int months) {
        double interestRate;
        if (months < 6) {
            interestRate = 0.07;
        } else if (months < 12) {
            interestRate = 0.085;
        } else {
            interestRate = 0.1;
        }
        return  interestRate;
    }
}
