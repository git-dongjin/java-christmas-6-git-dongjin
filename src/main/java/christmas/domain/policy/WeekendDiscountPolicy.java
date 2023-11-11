package christmas.domain.policy;

import christmas.domain.money.Money;
import christmas.domain.order.OrdersMenuCount;

public class WeekendDiscountPolicy implements WeekDiscountPolicy {
    private final Money profit;

    public WeekendDiscountPolicy(OrdersMenuCount menuCount) {
        this.profit = calculateProfit(menuCount);
    }

    @Override
    public String toString() {
        return "주말 할인: " + profit + "원";
    }

    private Money calculateProfit(OrdersMenuCount menuCount) {
        int mainCount = menuCount.getMainCount();
        return Money.YEAR_AMOUNT.multiply(mainCount).negative();
    }
}
