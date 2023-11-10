package christmas.domain;

public class OrderTotalBeforeDiscount {
    private final Money orderTotal;

    public OrderTotalBeforeDiscount(OrdersMenuCount orders) {
        this.orderTotal = orders.calculateOrderTotal();
    }

    @Override
    public String toString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + orderTotal + "원";
    }
}
