package christmas.domain.money;

import christmas.domain.policy.ProfitPolicies;
import christmas.domain.policy.ProfitPolicy;

public class ProfitTotal {
    private final ProfitPolicies profitPolicies;

    public ProfitTotal(ProfitPolicies profitPolicies) {
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
        return new ProfitTotal(profitPolicies.getProfitPoliciesExceptPresentPolicies()).getTotalProfit();
    }

    @Override
    public String toString() {
        return "<총혜택 금액>" + System.lineSeparator()
                + getTotalProfit() + "원" + System.lineSeparator();
    }
}
