package christmas.domain.policy;

import christmas.domain.Day;
import christmas.domain.money.Money;

public class ChristmasDiscountPolicy {
    private final Day day;

    public ChristmasDiscountPolicy(Day day) {
        this.day = day;
    }

    public Money getProfit() {
        if (day.isNotChristmasDiscountPeriod()) {
            return Money.ZERO;
        }
        Money profit = Money.THOUSAND;
        return profit.add(Money.HUNDRED.multiply(day.calculateDaysFromFirstDay())).negative();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.equals(Money.ZERO)) {
            return "";
        }

        return "크리스마스 디데이 할인: " + getProfit() + "원";
    }
}
