package christmas.domain.money;

import christmas.domain.order.OrdersMenuCount;

public class OrderTotalBeforeDiscount implements Comparable<Money> {
    private final Money orderTotal;

    public OrderTotalBeforeDiscount(OrdersMenuCount menuCount) {
        this.orderTotal = menuCount.calculateOrderTotal();
    }

    @Override
    public int compareTo(Money other) {
        return orderTotal.compareTo(other);
    }

    @Override
    public String toString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + orderTotal + "원" + System.lineSeparator();
    }
}
