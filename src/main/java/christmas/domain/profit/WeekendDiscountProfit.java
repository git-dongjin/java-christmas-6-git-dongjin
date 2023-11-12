package christmas.domain.profit;

import christmas.domain.period.WeekendDiscountPeriod;
import christmas.domain.unit.Money;
import christmas.domain.unit.OrdersMenuCount;

public class WeekendDiscountProfit {
    private final WeekendDiscountPeriod weekendDiscountDay;
    private final OrdersMenuCount ordersMenuCount;

    public WeekendDiscountProfit(WeekendDiscountPeriod weekendDiscountDay, OrdersMenuCount ordersMenuCount) {
        this.weekendDiscountDay = weekendDiscountDay;
        this.ordersMenuCount = ordersMenuCount;
    }

    public Money getProfit() {
        if (!weekendDiscountDay.isEventPeriod() || !weekendDiscountDay.isWeekend()) {
            return Money.ZERO;
        }
        return calculateProfit();
    }

    private Money calculateProfit() {
        int mainCount = ordersMenuCount.getMainCount();
        return Money.YEAR_AMOUNT.multiply(mainCount).negative();
    }
}
