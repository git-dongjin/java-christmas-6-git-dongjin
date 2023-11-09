package christmas.domain;

import christmas.enums.DecemberDays;

import java.time.DayOfWeek;

public class Day {
    private final int day;

    public Day(int day) {
        validate(day);
        this.day = day;
    }

    public DayOfWeek getWeekOfDay() {
        return DecemberDays.getDayOfWeek(day);
    }

    private void validate(int day) {
        if (!DecemberDays.contains(day)) {
            throw new IllegalArgumentException();
        }
    }
}
