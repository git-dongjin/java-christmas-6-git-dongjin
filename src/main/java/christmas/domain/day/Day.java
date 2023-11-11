package christmas.domain.day;

import christmas.enums.DayType;
import christmas.enums.Calendar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Day {
    public static final Day FIRST_DAY = new Day(Calendar.FIRST.getDay()),
            CHRISTMAS = new Day(Calendar.TWENTY_FIFTH.getDay());
    private final LocalDate day;

    public Day(int day) {
        validate(day);
        this.day = Calendar.convertIntegerToDecemberDay(day);
    }

    public boolean isBefore(Day other) {
        return day.isBefore(other.day);
    }

    public boolean isAfter(Day other) {
        return day.isAfter(other.day);
    }

    public long betweenFrom(Day other) {
        return ChronoUnit.DAYS.between(other.day, day);
    }

    public DayType getDayType() {
        return day.getDayType();
    }

    public boolean isStar() {
        return day.isStar();
    }

    @Override
    public String toString() {
        return day + "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + System.lineSeparator();
    }

    private void validate(int day) {
        if (!Calendar.contains(day)) {
            throw new IllegalArgumentException();
        }
    }
}
