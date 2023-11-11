package christmas.domain.money;

import christmas.domain.order.OrdersMenuCount;
import christmas.domain.policies.PresentGivePolicy;
import christmas.enums.Gift;

public class OrderTotalBeforeDiscount {
    private final Money orderTotal;

    public OrderTotalBeforeDiscount(OrdersMenuCount orders) {
        this.orderTotal = orders.calculateOrderTotal();
    }

    public PresentGivePolicy calculateGift() {
        return new PresentGivePolicy(Gift.getPresents(orderTotal));
    }

    @Override
    public String toString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + orderTotal + "원" + System.lineSeparator();
    }
}
