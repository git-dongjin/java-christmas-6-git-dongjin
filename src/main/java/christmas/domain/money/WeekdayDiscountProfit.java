package christmas.domain.money;

import christmas.domain.day.WeekdayDiscountDay;
import christmas.domain.order.OrdersMenuCount;

public class WeekdayDiscountProfit {
    private final WeekdayDiscountDay weekdayDiscountDay;
    private final OrdersMenuCount ordersMenuCount;

    public WeekdayDiscountProfit(WeekdayDiscountDay weekdayDiscountDay, OrdersMenuCount ordersMenuCount) {
        this.weekdayDiscountDay = weekdayDiscountDay;
        this.ordersMenuCount = ordersMenuCount;
    }

    public Money getProfit() {
        if (!weekdayDiscountDay.isEventPeriod() || weekdayDiscountDay.isWeekday()) {
            return Money.ZERO;
        }
        return calculateProfit();
    }

    private Money calculateProfit() {
        int desertCount = ordersMenuCount.getDessertCount();
        return Money.YEAR_AMOUNT.multiply(desertCount).negative();
    }
}
