package christmas.domain.money;

import christmas.domain.day.WeekdayDiscountDay;
import christmas.domain.order.OrdersMenuCount;

public class WeekendDiscountProfit {
    private final WeekdayDiscountDay weekdayDiscountDay;
    private final OrdersMenuCount ordersMenuCount;

    public WeekendDiscountProfit(WeekdayDiscountDay weekdayDiscountDay, OrdersMenuCount ordersMenuCount) {
        this.weekdayDiscountDay = weekdayDiscountDay;
        this.ordersMenuCount = ordersMenuCount;
    }

    public Money getProfit() {
        if (!weekdayDiscountDay.isEventPeriod() || !weekdayDiscountDay.isWeekday()) {
            return Money.ZERO;
        }
        return calculateProfit();
    }

    private Money calculateProfit() {
        int mainCount = ordersMenuCount.getMainCount();
        return Money.YEAR_AMOUNT.multiply(mainCount).negative();
    }
}
