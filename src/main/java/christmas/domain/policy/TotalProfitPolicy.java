package christmas.domain.policy;

import christmas.domain.unit.Money;

public class TotalProfitPolicy {
    private final ProfitPresentPolicy profitPresentPolicy;

    public TotalProfitPolicy(ProfitPresentPolicy profitPresentPolicy) {
        this.profitPresentPolicy = profitPresentPolicy;
    }

    public Money getTotalProfit() {
        return profitPresentPolicy.getTotalProfit();
    }

    public Money getTotalProfitExceptPresent() {
        return profitPresentPolicy.getTotalProfitExceptPresent();
    }

    @Override
    public String toString() {
        return "<총혜택 금액>" + System.lineSeparator()
                + getTotalProfit() + "원" + System.lineSeparator();
    }
}
