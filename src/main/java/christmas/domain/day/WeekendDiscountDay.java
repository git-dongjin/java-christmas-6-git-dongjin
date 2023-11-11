package christmas.domain.day;

public class WeekendDiscountDay {
    private static final Day START_DAY = Day.FIRST_DAY,
            END_DAY = Day.LAST_DAY;

    private final Day day;

    public WeekendDiscountDay(Day day) {
        this.day = day;
    }

    public boolean isEventPeriod() {
        return !(day.isBefore(START_DAY) || day.isAfter(END_DAY));
    }

    public boolean isWeekend() {
        return day.isWeekend();
    }
}
