package christmas.domain.policy;

import christmas.domain.unit.Money;

public interface PresentPolicy {
    String showPresents();
    Money getProfit();
}
