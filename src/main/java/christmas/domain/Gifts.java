package christmas.domain;

import christmas.enums.Gift;

import java.util.List;

public class Gifts {
    private final List<Gift> gifts;

    public Gifts(List<Gift> gifts) {
        validateNotDuplicate(gifts);
        this.gifts = gifts;
    }

    private void validateNotDuplicate(List<Gift> gifts) {
        if (gifts.size() != gifts.stream().distinct().count()) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        StringBuilder presentsBuilder = new StringBuilder("<증정 메뉴>").append(System.lineSeparator());

        if (gifts.isEmpty()) {
            return presentsBuilder.append("없음").append(System.lineSeparator()).toString();
        }

        for(Gift present : gifts) {
            presentsBuilder.append(present);
        }

        return presentsBuilder.toString();
    }
}
