package christmas.domain.policy;

import christmas.domain.unit.Day;
import christmas.enums.Badge;

public class BadgePolicy {
    private final Day day;
    private final Badge badge;

    public BadgePolicy(Day day, TotalProfitPolicy totalProfitPolicy) {
        this.day = day;
        this.badge = Badge.getBadge(totalProfitPolicy);
    }

    @Override
    public String toString() {
        return "<" + day.month() + " 이벤트 배지>" + System.lineSeparator() + badge + System.lineSeparator();
    }
}
