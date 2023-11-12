package christmas.domain.profit;

import christmas.domain.period.SpecialDiscountPeriod;
import christmas.domain.unit.Money;

public class SpecialDiscountProfit {
    private final SpecialDiscountPeriod specialDiscountDay;

    public SpecialDiscountProfit(SpecialDiscountPeriod specialDiscountDay) {
        this.specialDiscountDay = specialDiscountDay;
    }

    public Money getProfit() {
        if (!specialDiscountDay.isEventPeriod() || !specialDiscountDay.isStar()) {
            return Money.ZERO;
        }
        return Money.THOUSAND.negative();
    }
}
