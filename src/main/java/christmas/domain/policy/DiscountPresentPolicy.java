package christmas.domain.policy;

import christmas.domain.discount.Discounts;
import christmas.domain.present.PresentGive;
import christmas.domain.unit.Money;

public class DiscountPresentPolicy {
    private final PresentGive presentPolicy;
    private final Discounts profitPolicies;
    private final MinimumOrderTotalPolicy minimumOrderTotalPolicy;

    public DiscountPresentPolicy(PresentGive presentPolicy, Discounts profitPolicies, MinimumOrderTotalPolicy minimumOrderTotalPolicy) {
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
