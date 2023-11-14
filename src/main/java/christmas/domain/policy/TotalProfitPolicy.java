package christmas.domain.policy;

import christmas.domain.unit.Money;

public class TotalProfitPolicy {
    private final DiscountPresentPolicy discountPresentPolicy;

    public TotalProfitPolicy(DiscountPresentPolicy discountPresentPolicy) {
        this.discountPresentPolicy = discountPresentPolicy;
    }

    public Money getTotalProfit() {
        return discountPresentPolicy.getTotalProfit();
    }

    public Money getDiscountsProfit() {
        return discountPresentPolicy.getDiscountsProfit();
    }

    @Override
    public String toString() {
        return "<총혜택 금액>" + System.lineSeparator()
                + getTotalProfit() + "원" + System.lineSeparator();
    }
}
