package christmas.domain.policies;

import christmas.domain.Day;
import christmas.domain.money.Money;

public class SpecialDiscountPolicy {
    private final Day day;

    public SpecialDiscountPolicy(Day day) {
        this.day = day;
    }

    public Money getProfit() {
        if (day.isStar()) {
            return Money.THOUSAND.negative();
        }
        return Money.ZERO;
    }

    @Override
    public String toString() {
        if (day.isStar()) {
            return "특별 할인: " + getProfit() + "원";
        }
        return "";
    }
}
