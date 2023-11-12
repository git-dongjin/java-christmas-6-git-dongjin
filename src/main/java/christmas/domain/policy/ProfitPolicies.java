package christmas.domain.policy;

import java.util.Iterator;
import java.util.List;

public class ProfitPolicies implements Iterable<ProfitPolicy> {
    private final List<ProfitPolicy> profitPolicies;

    public ProfitPolicies(List<ProfitPolicy> profitPolicies) {
        validateNotDuplicateClasses(profitPolicies);
        this.profitPolicies = profitPolicies.stream().filter(value -> !value.getProfit().isZero()).toList();
    }

    public ProfitPolicies getProfitPoliciesExceptPresentPolicies() {
        return new ProfitPolicies(profitPolicies.stream().filter(value -> !(value instanceof PresentPolicy)).toList());
    }

    private void validateNotDuplicateClasses(List<ProfitPolicy> profitPolicies) {
        if (profitPolicies.size() != profitPolicies.stream().map(ProfitPolicy::getClass).distinct().count()) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        StringBuilder profitBuilder = new StringBuilder("<혜택 내역>").append(System.lineSeparator());

        if (profitPolicies.isEmpty()) {
            profitBuilder.append("없음").append(System.lineSeparator());
            return profitBuilder.toString();
        }

        for(ProfitPolicy profitPolicy : profitPolicies) {
            profitBuilder.append(profitPolicy).append(System.lineSeparator());
        }

        return profitBuilder.toString();
    }

    @Override
    public Iterator<ProfitPolicy> iterator() {
        return profitPolicies.iterator();
    }
}
