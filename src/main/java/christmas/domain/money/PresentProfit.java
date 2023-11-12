package christmas.domain.money;

import christmas.domain.day.PresentDay;
import christmas.domain.order.Presents;

public class PresentProfit {
    private final PresentDay presentDay;
    private final Presents presents;

    public PresentProfit(PresentDay presentDay, Presents presents) {
        this.presentDay = presentDay;
        this.presents = presents;
    }

    public Money getProfit() {
        if (!presentDay.isEventPeriod() || presents.isEmpty()) {
            return Money.ZERO;
        }
        return presents.getProfit();
    }
}
