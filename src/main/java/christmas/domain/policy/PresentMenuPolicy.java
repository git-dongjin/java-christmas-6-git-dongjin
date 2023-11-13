package christmas.domain.policy;

import christmas.domain.unit.Day;
import christmas.domain.period.PresentGivePeriod;
import christmas.domain.unit.Money;
import christmas.domain.total.OrderTotalBeforeDiscount;
import christmas.domain.profit.PresentGiveProfit;
import christmas.domain.unit.Presents;
import christmas.enums.Present;

import java.util.List;

public class PresentMenuPolicy implements PresentPolicy {
    private final Presents presents;
    private final PresentGiveProfit presentProfit;

    public PresentMenuPolicy(Day day, OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        List<Present> presents = Present.getPresents(orderTotalBeforeDiscount);
        this.presents = new Presents(presents);
        PresentGivePeriod presentDay = new PresentGivePeriod(day);

        this.presentProfit = new PresentGiveProfit(presentDay, this.presents);
    }

    @Override
    public String showPresents() {
        return presents.toString();
    }

    @Override
    public Money getProfit() {
        return presentProfit.getProfit();
    }

    @Override
    public String toString() {
        Money profit = getProfit();

        if (profit.isZero()) {
            return "";
        }

        return "증정 이벤트: " + profit + "원" + System.lineSeparator();
    }
}
