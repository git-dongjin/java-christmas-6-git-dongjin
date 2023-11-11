package christmas.domain.policy;

import christmas.domain.Day;
import christmas.domain.money.Money;

public class ChristmasDiscountPolicy {
    private final Money profit;

    public ChristmasDiscountPolicy(Day day) {
        Money profit = calculateProfit(day);
        validateProfit(profit);
        this.profit = profit;
    }

    @Override
    public String toString() {
        if (profit.isZero()) {
            return "";
        }

        return "크리스마스 디데이 할인: " + profit + "원";
    }

    private Money calculateProfit(Day day) {
        if (day.isNotChristmasDiscountPeriod()) {
            return Money.ZERO;
        }
        Money profit = Money.THOUSAND;
        return profit.add(Money.HUNDRED.multiply(day.calculateDaysFromFirstDay())).negative();
    }

    private void validateProfit(Money money) {
        if (money.isPositive()) {
            throw new IllegalStateException();
        }
    }
}
