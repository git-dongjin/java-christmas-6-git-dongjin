package christmas.domain.policy;

import christmas.domain.money.Money;

public interface DiscountPolicy {
    Money getProfit();
}
