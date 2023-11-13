package christmas.domain.policy;

import christmas.domain.unit.Money;

public class ProfitPresentPolicy {
    private final PresentPolicy presentPolicy;
    private final ProfitPolicies profitPolicies;
    private final MinimumOrderTotalPolicy minimumOrderTotalPolicy;

    public ProfitPresentPolicy(PresentPolicy presentPolicy, ProfitPolicies profitPolicies, MinimumOrderTotalPolicy minimumOrderTotalPolicy) {
        this.presentPolicy = presentPolicy;
        this.profitPolicies = profitPolicies;
        this.minimumOrderTotalPolicy = minimumOrderTotalPolicy;
    }

    public Money getTotalProfit() {
        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return Money.ZERO;
        }
        return profitPolicies.getTotalProfit().add(presentPolicy.getProfit());
    }

    public Money getTotalProfitExceptPresent() {
        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return Money.ZERO;
        }
        return profitPolicies.getTotalProfit();
    }

    public String presentsDetails() {
        StringBuilder presentsDetailsBuilder = new StringBuilder("<증정 메뉴>").append(System.lineSeparator());

        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return presentsDetailsBuilder.append("없음").append(System.lineSeparator()).toString();
        }

        return presentsDetailsBuilder.append(presentPolicy.showPresents()).toString();
    }

    public String profitDetails() {
        StringBuilder profitDetailsBuilder = new StringBuilder("<혜택 내역>").append(System.lineSeparator());

        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return profitDetailsBuilder.append("없음").append(System.lineSeparator()).toString();
        }

        return profitDetailsBuilder.append(profitPolicies).append(presentPolicy).toString();
    }
}
