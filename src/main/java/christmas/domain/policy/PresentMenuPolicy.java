package christmas.domain.policy;

import christmas.domain.money.Money;
import christmas.domain.money.OrderTotalBeforeDiscount;
import christmas.enums.Present;

import java.util.List;

public class PresentMenuPolicy implements ProfitPolicy, PresentPolicy {
    private final List<Present> presents;

    public PresentMenuPolicy(OrderTotalBeforeDiscount totalBeforeDiscount) {
        List<Present> presents = totalBeforeDiscount.calculatePresents();
        validateNotDuplicate(presents);
        this.presents = presents;
    }

    @Override
    public Money getProfit() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder presentsBuilder = new StringBuilder("<증정 메뉴>").append(System.lineSeparator());

        if (presents.isEmpty()) {
            return presentsBuilder.append("없음").append(System.lineSeparator()).toString();
        }

        for(Present present : presents) {
            presentsBuilder.append(present).append(System.lineSeparator());
        }

        return presentsBuilder.toString();
    }

    private void validateNotDuplicate(List<Present> gifts) {
        if (gifts.size() != gifts.stream().distinct().count()) {
            throw new IllegalStateException();
        }
    }
}
