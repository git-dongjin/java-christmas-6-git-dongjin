package christmas.domain.discount;

import christmas.domain.period.SpecialDiscountPeriod;
import christmas.domain.unit.Money;

public class SpecialDiscount implements Discount {
    private final SpecialDiscountPeriod specialDiscountDay;

    public SpecialDiscount(SpecialDiscountPeriod specialDiscountDay) {
        this.specialDiscountDay = specialDiscountDay;
    }

    @Override
    public Money getProfit() {
        if (!specialDiscountDay.isEventPeriod() || !specialDiscountDay.isStar()) {
            return Money.ZERO;
        }
        return Money.THOUSAND.negative();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "특별 할인: " + profit + "원";
    }
}
