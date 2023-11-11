package christmas.domain.policy;

import christmas.domain.day.ChristmasDiscountDay;
import christmas.domain.day.Day;
import christmas.domain.money.ChristmasDiscountProfit;
import christmas.domain.money.Money;

public class ChristmasDiscountPolicy implements ProfitPolicy {
    private final ChristmasDiscountProfit christmasProfit;

    public ChristmasDiscountPolicy(Day day) {
        ChristmasDiscountDay christmasDiscountDay = new ChristmasDiscountDay(day);
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
