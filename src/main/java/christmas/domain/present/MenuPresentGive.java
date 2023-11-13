package christmas.domain.present;

import christmas.domain.period.MenuPresentGivePeriod;
import christmas.domain.total.OrderTotalBeforeDiscount;
import christmas.domain.unit.Money;
import christmas.domain.unit.Presents;
import christmas.enums.Present;

public class MenuPresentGive implements PresentGive {
    private final MenuPresentGivePeriod presentDay;
    private final Presents presents;

    public MenuPresentGive(MenuPresentGivePeriod presentGivePeriod, OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        this.presentDay = presentGivePeriod;
        this.presents = new Presents(Present.getPresents(orderTotalBeforeDiscount));
    }

    @Override
    public Money getProfit() {
        if (!presentDay.isEventPeriod() || presents.isEmpty()) {
            return Money.ZERO;
        }
        return presents.getProfit();
    }

    @Override
    public String showPresents() {
        return presents.toString();
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
