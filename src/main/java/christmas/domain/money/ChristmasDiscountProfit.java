package christmas.domain.money;

import christmas.domain.day.ChristmasDiscountDay;

public class ChristmasDiscountProfit {
    private final ChristmasDiscountDay christmasDiscountDay;

    public ChristmasDiscountProfit(ChristmasDiscountDay christmasDiscountDay) {
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
