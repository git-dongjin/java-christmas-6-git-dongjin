package christmas.domain;

import christmas.enums.DayType;

public class WeekDiscount {
    private final Day day;
    private final OrdersMenuCount ordersMenuCount;

    public WeekDiscount(Day day, OrdersMenuCount ordersMenuCount) {
        this.day = day;
        this.ordersMenuCount = ordersMenuCount;
    }

    public Money getProfit() {
        if (day.getDayType() == DayType.WEEKDAY) {
            int desertCount = ordersMenuCount.getDesertCount();
            return Money.YEAR_AMOUNT.multiply(desertCount).negative();
        }
        int mainCount = ordersMenuCount.getMainCount();
        return Money.YEAR_AMOUNT.multiply(mainCount).negative();
    }

    @Override
    public String toString() {
        if (day.getDayType() == DayType.WEEKDAY) {
            return weekdayMessage();
        }
        return weekendMessage();
    }

    private String weekdayMessage() {
        return "평일 할인: " + getProfit() + "원";
    }

    private String weekendMessage() {
        return "주말 할인: " + getProfit() + "원";
    }
}
