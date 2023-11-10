package christmas.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class OrderTotalBeforeDiscount {
    private final BigDecimal orderTotal;

    public OrderTotalBeforeDiscount(Orders orders) {
        this.orderTotal = orders.calculateOrderTotal();
    }

    @Override
    public String toString() {
        return "<할인 전 총주문 금액>" + System.lineSeparator()
                + moneyFormat(orderTotal) + "원";
    }

    private String moneyFormat(BigDecimal money) {
        DecimalFormat moneyFormat = new DecimalFormat("###,###");
        return moneyFormat.format(money);
    }
}
