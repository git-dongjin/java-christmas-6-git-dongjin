package christmas.domain.discount;

import christmas.domain.period.WeekendDiscountPeriod;
import christmas.domain.unit.Money;
import christmas.domain.unit.OrdersMenuCount;

public class WeekendDiscount implements Discount {
    private final WeekendDiscountPeriod weekendDiscountDay;
    private final OrdersMenuCount ordersMenuCount;

    public WeekendDiscount(WeekendDiscountPeriod weekendDiscountDay, OrdersMenuCount ordersMenuCount) {
        this.weekendDiscountDay = weekendDiscountDay;
        this.ordersMenuCount = ordersMenuCount;
    }

    @Override
    public Money getProfit() {
        if (!weekendDiscountDay.isEventPeriod() || !weekendDiscountDay.isWeekend()) {
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

        return "주말 할인: " + profit + "원";
    }

    private Money calculateProfit() {
        int mainCount = ordersMenuCount.getMainCount();
        return Money.YEAR_AMOUNT.multiply(mainCount).negative();
    }
}
