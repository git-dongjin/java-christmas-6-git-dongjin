package christmas.domain.policy;

import christmas.domain.money.Money;
import christmas.domain.money.OrderTotalBeforeDiscount;

public class MinimumOrderTotalPolicy {
    private static final Money minimumOrderTotal = Money.TEN_THOUSAND;
    private final OrderTotalBeforeDiscount orderTotalBeforeDiscount;

    public MinimumOrderTotalPolicy(OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        this.orderTotalBeforeDiscount = orderTotalBeforeDiscount;
    }

    public boolean isEventAvailable() {
        return orderTotalBeforeDiscount.isEventAvailable(minimumOrderTotal);
    }
}
