package org.samsung.Refactor;

import org.junit.jupiter.api.Test;
import org.hamcrest.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InterestCalculatorTest {
    @Test
    public void should_answer_true_with_positive_principal_and_period_and_correct_type() {
        double principal = 1000000;
        int period = 12;
        double expected = principal*period*(0.1)/12;
        MatcherAssert.assertThat(expected, Matchers.equalTo(BankInterestCalculator.calculateInterest(principal,period, BankInterestCalculator.AccountType.VIP)));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/customerData.csv", numLinesToSkip = 1)
    public void bulkTest(double principal, int period, BankInterestCalculator.AccountType type, double interestRate, double expected) {
        System.out.println(type);
        MatcherAssert.assertThat(expected, Matchers.equalTo(BankInterestCalculator.calculateInterest(principal,period, type)));
    }
}
