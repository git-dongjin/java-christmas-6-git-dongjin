package christmas.domain.policy;

import christmas.domain.Day;
import christmas.domain.money.Money;

public class SpecialDiscountPolicy {
    private final Money profit;

    public SpecialDiscountPolicy(Day day) {
        Money profit = calculateProfit(day);
        validateProfit(profit);
        this.profit = calculateProfit(day);
    }

    @Override
    public String toString() {
        if (profit.isZero()) {
            return "";
        }
        return "특별 할인: " + profit + "원";
    }

    private Money calculateProfit(Day day) {
        if (day.isStar()) {
            return Money.THOUSAND.negative();
        }
        return Money.ZERO;
    }

    private void validateProfit(Money profit) {
        if (profit.isPositive()) {
            throw new IllegalStateException();
        }
    }
}
