package christmas.domain.day;

public class ChristmasDiscountDay {
    private static final Day START_DAY = Day.FIRST_DAY,
            LAST_DAY = Day.CHRISTMAS;
    private final Day day;

    public ChristmasDiscountDay(Day day) {
        this.day = day;
    }

    public boolean isEventPeriod() {
        return !(day.isBefore(START_DAY) || day.isAfter(LAST_DAY));
    }

    public long calculateDaysFromStart() {
        return day.betweenFrom(START_DAY);
    }
}
