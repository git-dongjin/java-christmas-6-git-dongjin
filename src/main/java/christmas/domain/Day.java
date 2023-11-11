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

    @Override
    public String toString() {
        return day + "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + System.lineSeparator();
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
