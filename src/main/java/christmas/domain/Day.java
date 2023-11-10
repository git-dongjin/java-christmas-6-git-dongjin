package christmas.domain;

import christmas.enums.DayType;
import christmas.enums.DecemberDay;

public class Day {
    private final DecemberDay day;

    public Day(int day) {
        validate(day);
        this.day = convertIntegerToDecemberDay(day);
    }

    public DayType getDayType() {
        return day.getDayType();
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
