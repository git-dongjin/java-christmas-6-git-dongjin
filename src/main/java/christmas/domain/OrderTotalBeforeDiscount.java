package christmas.domain;

import christmas.enums.Gift;

public class OrderTotalBeforeDiscount {
    private final Money orderTotal;

    public OrderTotalBeforeDiscount(OrdersMenuCount orders) {
        this.orderTotal = orders.calculateOrderTotal();
    }

    public Gifts calculateGift() {
        return new Gifts(Gift.getPresents(orderTotal));
    }

    @Override
    public String toString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + orderTotal + "원" + System.lineSeparator();
    }
}
