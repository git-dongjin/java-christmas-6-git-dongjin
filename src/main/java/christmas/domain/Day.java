package christmas.domain;

import christmas.enums.DecemberDay;

import java.time.DayOfWeek;

public class Day {
    private final DecemberDay day;

    public Day(int day) {
        validate(day);
        this.day = convertIntegerToDecemberDay(day);
    }

    public DayOfWeek getWeekOfDay() {
        return day.getDayOfWeek();
    }

    private void validate(int day) {
        if (!DecemberDay.contains(day)) {
            throw new IllegalArgumentException();
        }
    }

    private DecemberDay convertIntegerToDecemberDay(int day) {
        return DecemberDay.convertIntegerToDecemberDay(day);
    }
}
