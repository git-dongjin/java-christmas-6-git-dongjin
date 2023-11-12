package christmas.domain.money;

import christmas.domain.day.WeekendDiscountDay;
import christmas.domain.order.OrdersMenuCount;

public class WeekendDiscountProfit {
    private final WeekendDiscountDay weekendDiscountDay;
    private final OrdersMenuCount ordersMenuCount;

    public WeekendDiscountProfit(WeekendDiscountDay weekendDiscountDay, OrdersMenuCount ordersMenuCount) {
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
