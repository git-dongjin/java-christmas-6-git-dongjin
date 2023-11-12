package christmas.domain.profit;

import christmas.domain.period.ChristmasDiscountPeriod;
import christmas.domain.unit.Money;

public class ChristmasDiscountProfit {
    private final ChristmasDiscountPeriod christmasDiscountDay;

    public ChristmasDiscountProfit(ChristmasDiscountPeriod christmasDiscountDay) {
        this.christmasDiscountDay = christmasDiscountDay;
    }

    public Money getProfit() {
        if (!christmasDiscountDay.isEventPeriod()) {
            return Money.ZERO;
        }
        return calculateProfit();
    }

    private Money calculateProfit() {
        Money profit = Money.THOUSAND;
        return profit.add(Money.HUNDRED.multiply(christmasDiscountDay.calculateDaysFromStart())).negative();
    }
}
