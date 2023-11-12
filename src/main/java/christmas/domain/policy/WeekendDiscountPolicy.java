package christmas.domain.policy;

import christmas.domain.unit.Day;
import christmas.domain.period.WeekendDiscountPeriod;
import christmas.domain.unit.Money;
import christmas.domain.profit.WeekendDiscountProfit;
import christmas.domain.unit.OrdersMenuCount;

public class WeekendDiscountPolicy implements ProfitPolicy {
    private final WeekendDiscountProfit weekendDiscountProfit;

    public WeekendDiscountPolicy(Day day, OrdersMenuCount ordersMenuCount) {
        WeekendDiscountPeriod weekendDiscountDay = new WeekendDiscountPeriod(day);
        this.weekendDiscountProfit = new WeekendDiscountProfit(weekendDiscountDay, ordersMenuCount);
    }

    @Override
    public Money getProfit() {
        return weekendDiscountProfit.getProfit();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "주말 할인: " + profit + "원";
    }
}
