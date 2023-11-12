package christmas.domain.policy;

import christmas.domain.unit.Day;
import christmas.domain.period.SpecialDiscountPeriod;
import christmas.domain.unit.Money;
import christmas.domain.profit.SpecialDiscountProfit;

public class SpecialDiscountPolicy implements ProfitPolicy {
    private final SpecialDiscountProfit specialDiscountProfit;

    public SpecialDiscountPolicy(Day day) {
        SpecialDiscountPeriod specialDiscountDay = new SpecialDiscountPeriod(day);
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
