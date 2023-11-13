package christmas.domain.discount;

import christmas.domain.period.ChristmasDiscountPeriod;
import christmas.domain.unit.Money;

public class ChristmasDiscount implements Discount {
    private final ChristmasDiscountPeriod christmasDiscountDay;

    public ChristmasDiscount(ChristmasDiscountPeriod christmasDiscountDay) {
        this.christmasDiscountDay = christmasDiscountDay;
    }

    @Override
    public Money getProfit() {
        if (!christmasDiscountDay.isEventPeriod()) {
            return Money.ZERO;
        }
        return calculateProfit();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "크리스마스 디데이 할인: " + profit + "원";
    }

    private Money calculateProfit() {
        Money profit = Money.THOUSAND;
        return profit.add(Money.HUNDRED.multiply(christmasDiscountDay.calculateDaysFromStart())).negative();
    }
}
