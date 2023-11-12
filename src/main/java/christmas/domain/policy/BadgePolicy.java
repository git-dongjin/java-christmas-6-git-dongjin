package christmas.domain.policy;

import christmas.domain.money.ProfitTotal;
import christmas.enums.Badge;

public class BadgePolicy {
    private final Badge badge;

    public BadgePolicy(ProfitTotal profitTotal) {
        this.badge = Badge.getBadge(profitTotal);
    }

    @Override
    public String toString() {
        return "<12월 이벤트 배지>" + System.lineSeparator()
                + badge;
    }
}