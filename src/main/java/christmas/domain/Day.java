package christmas.domain;

import christmas.enums.DecemberCalendar;

import java.time.DayOfWeek;

public class Day {
    private final int day;

    public Day(int day) {
        validate(day);
        this.day = day;
    }

    public DayOfWeek getWeekOfDay() {
        return DecemberCalendar.getDayOfWeek(day);
    }

    private void validate(int day) {
        if (!DecemberCalendar.contains(day)) {
            throw new IllegalArgumentException();
        }
    }
}
