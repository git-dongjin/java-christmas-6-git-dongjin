package christmas.domain.total;

import christmas.domain.profit.TotalProfit;
import christmas.domain.unit.Money;
import christmas.domain.unit.OrdersMenuCount;

public class OrderTotalBeforeDiscount {
    private final Money orderTotal;

    public OrderTotalBeforeDiscount(OrdersMenuCount menuCount) {
        this.orderTotal = menuCount.calculateOrderTotal();
    }

    public boolean isEventAvailable(Money minimumOrderTotal) {
        return orderTotal.notLessThan(minimumOrderTotal);
    }

    public Money calculateExpectedTotal(TotalProfit profitTotal) {
        return orderTotal.add(profitTotal.getTotalProfitExceptPresent());
    }

    public boolean notLessThan(Money other) {
        return orderTotal.notLessThan(other);
    }

    @Override
    public String toString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + orderTotal + "원" + System.lineSeparator();
    }
}
