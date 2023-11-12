package christmas.domain.policy;

import java.util.List;

public class ProfitPolicies {
    private final List<ProfitPolicy> profitPolicies;

    public ProfitPolicies(List<ProfitPolicy> profitPolicies) {
        validateNotDuplicateClasses(profitPolicies);
        this.profitPolicies = profitPolicies;
    }

    private void validateNotDuplicateClasses(List<ProfitPolicy> profitPolicies) {
        if (profitPolicies.size() != profitPolicies.stream().map(ProfitPolicy::getClass).distinct().count()) {
            throw new IllegalStateException();
        }
    }
}
