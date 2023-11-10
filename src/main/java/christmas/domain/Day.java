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

    public boolean isNotChristmasDiscountPeriod() {
        return day.isNotChristmasDiscountPeriod();
    }

    public long calculateDaysFromFirstDay() {
        if (isNotChristmasDiscountPeriod()) {
            throw new IllegalStateException();
        }
        return day.calculateDaysFromFirstDay();
    }

    public boolean isStar() {
        return day.isStar();
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
