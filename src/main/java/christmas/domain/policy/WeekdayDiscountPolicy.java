package christmas.domain.policy;

import christmas.domain.unit.Day;
import christmas.domain.period.WeekdayDiscountPeriod;
import christmas.domain.unit.Money;
import christmas.domain.profit.WeekdayDiscountProfit;
import christmas.domain.unit.OrdersMenuCount;

public class WeekdayDiscountPolicy implements ProfitPolicy {
    private final WeekdayDiscountProfit weekdayDiscountProfit;

    public WeekdayDiscountPolicy(Day day, OrdersMenuCount ordersMenuCount) {
        WeekdayDiscountPeriod weekdayDiscountDay = new WeekdayDiscountPeriod(day);
        this.weekdayDiscountProfit = new WeekdayDiscountProfit(weekdayDiscountDay, ordersMenuCount);
    }

    @Override
    public Money getProfit() {
        return weekdayDiscountProfit.getProfit();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "평일 할인: " + profit + "원";
    }
}
