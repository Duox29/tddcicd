package org.samsung.Refactor;

import java.util.EnumMap;
import java.util.Map;

public class BankInterestCalculator {
    public enum AccountType{
        STANDARD,PREMIUM,VIP
    }
    private static final Map<AccountType,InterestStrategy> strategies = new EnumMap<>(AccountType.class);
    public  BankInterestCalculator(){
        strategies.put(AccountType.STANDARD, new StandardInterest());
        strategies.put(AccountType.PREMIUM, new PremiumStrategy());
        strategies.put(AccountType.VIP, new VipStrategy());
    }
    public static double calculateInterest(double principal, int months, AccountType type){
        if(principal < 0 || months < 0) return 0.0;
        InterestStrategy strategy = strategies.get(type);
        if(strategy == null) throw new IllegalArgumentException("unknown account type");
        double rate = strategy.calculateRate(months);
        return principal * rate *months /12;
        }
    }