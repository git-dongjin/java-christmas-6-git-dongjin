package christmas.domain.policy;

import christmas.domain.day.Day;
import christmas.domain.day.WeekendDiscountDay;
import christmas.domain.money.Money;
import christmas.domain.money.WeekendDiscountProfit;
import christmas.domain.order.OrdersMenuCount;

public class WeekendDiscountPolicy implements ProfitPolicy {
    private final WeekendDiscountProfit weekendDiscountProfit;

    public WeekendDiscountPolicy(Day day, OrdersMenuCount ordersMenuCount) {
        WeekendDiscountDay weekendDiscountDay = new WeekendDiscountDay(day);
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
