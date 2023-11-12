package christmas.domain.profit;

import christmas.domain.period.PresentGivePeriod;
import christmas.domain.unit.Money;
import christmas.domain.unit.Presents;

public class PresentGiveProfit {
    private final PresentGivePeriod presentDay;
    private final Presents presents;

    public PresentGiveProfit(PresentGivePeriod presentDay, Presents presents) {
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
