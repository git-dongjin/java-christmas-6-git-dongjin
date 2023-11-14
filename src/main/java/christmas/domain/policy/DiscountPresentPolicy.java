package christmas.domain.policy;

import christmas.domain.discount.Discounts;
import christmas.domain.present.PresentGive;
import christmas.domain.unit.Money;

public class DiscountPresentPolicy {
    private static final Money NO_PROFIT = Money.ZERO;
    private final PresentGive presentGive;
    private final Discounts discounts;
    private final MinimumOrderTotalPolicy minimumOrderTotalPolicy;

    public DiscountPresentPolicy(PresentGive presentGive, Discounts discounts, MinimumOrderTotalPolicy minimumOrderTotalPolicy) {
        this.presentGive = presentGive;
        this.discounts = discounts;
        this.minimumOrderTotalPolicy = minimumOrderTotalPolicy;
    }

    public Money getTotalProfit() {
        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return NO_PROFIT;
        }
        return discounts.getTotalProfit().add(presentGive.getProfit());
    }

    public Money getDiscountsProfit() {
        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return NO_PROFIT;
        }
        return discounts.getTotalProfit();
    }

    public String presentsDetails() {
        StringBuilder presentsDetailsBuilder = new StringBuilder("<증정 메뉴>").append(System.lineSeparator());

        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return presentsDetailsBuilder.append("없음").append(System.lineSeparator()).toString();
        }

        return presentsDetailsBuilder.append(presentGive.showPresents()).toString();
    }

    public String profitDetails() {
        StringBuilder profitDetailsBuilder = new StringBuilder("<혜택 내역>").append(System.lineSeparator());

        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return profitDetailsBuilder.append("없음").append(System.lineSeparator()).toString();
        }

        return profitDetailsBuilder.append(discounts).append(presentGive).toString();
    }
}
