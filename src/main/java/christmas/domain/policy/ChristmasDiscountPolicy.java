package christmas.domain.policy;

import christmas.domain.period.ChristmasDiscountPeriod;
import christmas.domain.unit.Day;
import christmas.domain.profit.ChristmasDiscountProfit;
import christmas.domain.unit.Money;

public class ChristmasDiscountPolicy implements ProfitPolicy {
    private final ChristmasDiscountProfit christmasProfit;

    public ChristmasDiscountPolicy(Day day) {
        ChristmasDiscountPeriod christmasDiscountDay = new ChristmasDiscountPeriod(day);
        this.christmasProfit = new ChristmasDiscountProfit(christmasDiscountDay);
    }

    @Override
    public Money getProfit() {
        return christmasProfit.getProfit();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "크리스마스 디데이 할인: " + profit + "원";
    }
}
