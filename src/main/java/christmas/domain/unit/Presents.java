package christmas.domain.unit;

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
        Money totalProfit = Money.ZERO;

        for(Present present : presents) {
            totalProfit = totalProfit.add(present.getPresentProfit());
        }

        return totalProfit;
    }

    @Override
    public String toString() {
        StringBuilder presentsBuilder = new StringBuilder();

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
