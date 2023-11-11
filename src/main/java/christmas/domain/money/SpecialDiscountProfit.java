package christmas.domain.money;

import christmas.domain.day.SpecialDiscountDay;

public class SpecialDiscountProfit {
    private final SpecialDiscountDay specialDiscountDay;

    public SpecialDiscountProfit(SpecialDiscountDay specialDiscountDay) {
        this.specialDiscountDay = specialDiscountDay;
    }

    public Money getProfit() {
        if (!specialDiscountDay.isEventPeriod() || !specialDiscountDay.isStar()) {
            return Money.ZERO;
        }
        return Money.THOUSAND.negative();
    }
}
