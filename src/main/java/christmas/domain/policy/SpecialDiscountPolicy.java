package christmas.domain.policy;

import christmas.domain.day.Day;
import christmas.domain.day.SpecialDiscountDay;
import christmas.domain.money.Money;
import christmas.domain.money.SpecialDiscountProfit;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private final SpecialDiscountProfit specialDiscountProfit;

    public SpecialDiscountPolicy(Day day) {
        SpecialDiscountDay specialDiscountDay = new SpecialDiscountDay(day);
        this.specialDiscountProfit = new SpecialDiscountProfit(specialDiscountDay);
    }

    @Override
    public Money getProfit() {
        return specialDiscountProfit.getProfit();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "특별 할인: " + profit + "원";
    }
}
