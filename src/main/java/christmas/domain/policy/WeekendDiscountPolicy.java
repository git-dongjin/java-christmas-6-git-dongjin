package christmas.domain.policy;

import christmas.domain.money.Money;
import christmas.domain.order.OrdersMenuCount;

public class WeekendDiscountPolicy implements WeekDiscountPolicy {
    private final Money profit;

    public WeekendDiscountPolicy(OrdersMenuCount menuCount) {
        Money profit = calculateProfit(menuCount);
        validateProfit(profit);
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "주말 할인: " + profit + "원";
    }

    private Money calculateProfit(OrdersMenuCount menuCount) {
        int mainCount = menuCount.getMainCount();
        return Money.YEAR_AMOUNT.multiply(mainCount).negative();
    }

    private void validateProfit(Money profit) {
        if (profit.isPositive()) {
            throw new IllegalStateException();
        }
    }
}
