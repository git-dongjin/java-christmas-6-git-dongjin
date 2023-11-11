package christmas.domain.policy;

import christmas.domain.money.Money;
import christmas.domain.order.OrdersMenuCount;

public class WeekdayDiscountPolicy implements WeekDiscountPolicy {
    private final Money profit;

    public WeekdayDiscountPolicy(OrdersMenuCount menuCount) {
        this.profit = calculateProfit(menuCount);
    }

    @Override
    public String toString() {
        return "평일 할인: " + profit + "원";
    }

    private Money calculateProfit(OrdersMenuCount menuCount) {
        int desertCount = menuCount.getDesertCount();
        return Money.YEAR_AMOUNT.multiply(desertCount).negative();
    }
}
