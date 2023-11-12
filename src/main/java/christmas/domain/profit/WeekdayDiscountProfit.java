package christmas.domain.profit;

import christmas.domain.period.WeekdayDiscountPeriod;
import christmas.domain.unit.Money;
import christmas.domain.unit.OrdersMenuCount;

public class WeekdayDiscountProfit {
    private final WeekdayDiscountPeriod weekdayDiscountDay;
    private final OrdersMenuCount ordersMenuCount;

    public WeekdayDiscountProfit(WeekdayDiscountPeriod weekdayDiscountDay, OrdersMenuCount ordersMenuCount) {
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
        int desertCount = ordersMenuCount.getDessertCount();
        return Money.YEAR_AMOUNT.multiply(desertCount).negative();
    }
}
