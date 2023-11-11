package christmas.domain.day;

import java.time.LocalDate;

public class ChristmasDiscountDay {
    private final Day day;

    public ChristmasDiscountDay(Day day) {
        this.day = day;
    }

    public boolean isEventPeriod() {
        return false; -
    }
}
