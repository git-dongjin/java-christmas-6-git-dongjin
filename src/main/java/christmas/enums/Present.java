package christmas.enums;

import christmas.domain.money.Money;
import christmas.domain.money.OrderTotalBeforeDiscount;

import java.util.Arrays;
import java.util.List;

public enum Present {
    CHAMPAGNE(new Money(120_000L), "샴페인", 1);
    private static final int SAME = 0;
    private final Money min;
    private final String name;
    private final int count;

    public static List<Present> getPresents(OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        return Arrays.stream(values()).filter(value -> orderTotalBeforeDiscount.compareTo(value.min) >= SAME).toList();
    }

    public static Money getTotalProfit(List<Present> presents) {
        validateNotDuplicate(presents);

        Money profit = Money.ZERO;

        for(Present present : presents) {
            Menu menu = Menu.convertStringToMenu(present.name);
            profit = profit.add(menu.multiply(present.count));
        }

        return profit;
    }

    private static void validateNotDuplicate(List<Present> presents) {
        if (presents.size() != presents.stream().distinct().count()) {
            throw new IllegalStateException();
        }
    }

    Present(Money min, String name, int count) {
        this.min = min;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return name + " " + String.valueOf(count) + "개" + System.lineSeparator();
    }
}
