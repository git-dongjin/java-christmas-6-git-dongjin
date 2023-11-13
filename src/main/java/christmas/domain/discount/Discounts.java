package christmas.domain.discount;

import christmas.domain.unit.Money;

import java.util.Iterator;
import java.util.List;

public class Discounts implements Iterable<Discount> {
    private final List<Discount> discountProfits;

    public Discounts(List<Discount> profitPolicies) {
        validateNotDuplicateClasses(profitPolicies);
        this.discountProfits = profitPolicies.stream().filter(value -> !value.getProfit().isZero()).toList();
    }

    public Money getTotalProfit() {
        Money totalProfit = Money.ZERO;

        for(Discount discountProfit : discountProfits) {
            totalProfit = totalProfit.add(discountProfit.getProfit());
        }

        return totalProfit;
    }

    @Override
    public String toString() {
        StringBuilder profitBuilder = new StringBuilder();

        if (discountProfits.isEmpty()) {
            profitBuilder.append("없음").append(System.lineSeparator());
            return profitBuilder.toString();
        }

        for(Discount profitPolicy : discountProfits) {
            profitBuilder.append(profitPolicy).append(System.lineSeparator());
        }

        return profitBuilder.toString();
    }

    @Override
    public Iterator<Discount> iterator() {
        return discountProfits.iterator();
    }

    private void validateNotDuplicateClasses(List<Discount> profitPolicies) {
        if (profitPolicies.size() != profitPolicies.stream().map(Discount::getClass).distinct().count()) {
            throw new IllegalStateException();
        }
    }
}