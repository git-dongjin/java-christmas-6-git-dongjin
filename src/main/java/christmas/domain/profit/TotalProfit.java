package christmas.domain.profit;

import christmas.domain.policy.ProfitPolicies;
import christmas.domain.policy.ProfitPolicy;
import christmas.domain.unit.Money;

public class TotalProfit {
    private final ProfitPolicies profitPolicies;

    public TotalProfit(ProfitPolicies profitPolicies) {
        this.profitPolicies = profitPolicies;
    }

    public Money getTotalProfit() {
        Money totalProfit = Money.ZERO;

        for (ProfitPolicy profitPolicy : profitPolicies) {
            totalProfit = totalProfit.add(profitPolicy.getProfit());
        }

        return totalProfit;
    }

    public Money getTotalProfitExceptPresent() {
        return new TotalProfit(profitPolicies.getProfitPoliciesExceptPresentPolicies()).getTotalProfit();
    }

    @Override
    public String toString() {
        return "<총혜택 금액>" + System.lineSeparator()
                + getTotalProfit() + "원" + System.lineSeparator();
    }
}
