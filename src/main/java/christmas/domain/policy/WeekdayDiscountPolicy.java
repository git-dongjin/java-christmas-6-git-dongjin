package christmas.domain.policy;

import christmas.domain.day.Day;
import christmas.domain.day.WeekdayDiscountDay;
import christmas.domain.money.Money;
import christmas.domain.money.WeekdayDiscountProfit;
import christmas.domain.order.OrdersMenuCount;

public class WeekdayDiscountPolicy implements ProfitPolicy {
    private final WeekdayDiscountProfit weekdayDiscountProfit;

    public WeekdayDiscountPolicy(Day day, OrdersMenuCount ordersMenuCount) {
        WeekdayDiscountDay weekdayDiscountDay = new WeekdayDiscountDay(day);
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
