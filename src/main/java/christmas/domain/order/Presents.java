package christmas.domain.order;

import christmas.domain.money.Money;
import christmas.enums.Present;

import java.util.List;

public class Presents {
    private final List<Present> presents;

    public Presents(List<Present> presents) {
        validateNotDuplicate(presents);
        this.presents = presents;
    }

    public boolean isEmpty() {
        return presents.isEmpty();
    }

    public Money getProfit() {
        return Present.getTotalProfit(presents);
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

    private void validateNotDuplicate(List<Present> presents) {
        if (presents.size() != presents.stream().distinct().count()) {
            throw new IllegalStateException();
        }
    }
}
