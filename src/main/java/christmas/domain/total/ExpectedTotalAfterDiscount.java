package christmas.domain.total;

import christmas.domain.profit.TotalProfit;
import christmas.domain.unit.Money;

public class ExpectedTotalAfterDiscount {
    private final Money expectedTotal;

    public ExpectedTotalAfterDiscount(OrderTotalBeforeDiscount orderTotalBeforeDiscount, TotalProfit profitTotal) {
        this.expectedTotal = orderTotalBeforeDiscount.calculateExpectedTotal(profitTotal);
    }

    @Override
    public String toString() {
        return "<할인 후 예상 결제 금액>" + System.lineSeparator()
                + expectedTotal + "원" + System.lineSeparator();
    }
}
