package christmas.domain.discount;

import christmas.domain.period.WeekdayDiscountPeriod;
import christmas.domain.unit.Money;
import christmas.domain.unit.OrdersMenuCount;

public class WeekdayDiscount implements Discount {
    private final WeekdayDiscountPeriod weekdayDiscountDay;
    private final OrdersMenuCount ordersMenuCount;

    public WeekdayDiscount(WeekdayDiscountPeriod weekdayDiscountDay, OrdersMenuCount ordersMenuCount) {
        this.weekdayDiscountDay = weekdayDiscountDay;
        this.ordersMenuCount = ordersMenuCount;
    }

    @Override
    public Money getProfit() {
        if (!weekdayDiscountDay.isEventPeriod() || !weekdayDiscountDay.isWeekday()) {
            return Money.ZERO;
        }
        return calculateProfit();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "평일 할인: " + profit + "원";
    }

    private Money calculateProfit() {
        int desertCount = ordersMenuCount.getDessertCount();
        return Money.YEAR_AMOUNT.multiply(desertCount).negative();
    }
}
