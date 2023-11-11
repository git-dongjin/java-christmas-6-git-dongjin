package christmas.domain.money;

import christmas.domain.order.OrdersMenuCount;
import christmas.domain.policy.PresentListPolicy;
import christmas.enums.Present;

import java.util.List;

public class OrderTotalBeforeDiscount {
    private final Money orderTotal;

    public OrderTotalBeforeDiscount(OrdersMenuCount menuCount) {
        this.orderTotal = menuCount.calculateOrderTotal();
    }

    public List<Present> calculatePresents() {
        return Present.getPresents(orderTotal);
    }

    @Override
    public String toString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + orderTotal + "원" + System.lineSeparator();
    }
}
