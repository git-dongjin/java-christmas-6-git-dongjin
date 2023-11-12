package christmas.domain.policy;

import christmas.domain.day.Day;
import christmas.domain.day.PresentDay;
import christmas.domain.money.Money;
import christmas.domain.money.OrderTotalBeforeDiscount;
import christmas.domain.money.PresentProfit;
import christmas.domain.order.Presents;
import christmas.enums.Present;

import java.util.List;

public class PresentMenuPolicy implements ProfitPolicy, PresentPolicy {
    private final Presents presents;
    private final PresentProfit presentProfit;

    public PresentMenuPolicy(Day day, OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        List<Present> presents = Present.getPresents(orderTotalBeforeDiscount);
        this.presents = new Presents(presents);
        PresentDay presentDay = new PresentDay(day);

        this.presentProfit = new PresentProfit(presentDay, this.presents);
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

        return "증정 이벤트: " + profit + "원";
    }
}
