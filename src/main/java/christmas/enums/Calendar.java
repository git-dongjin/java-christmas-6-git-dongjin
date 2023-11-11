package christmas.enums;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Calendar {
    FIRST(1, false), SECOND(2, false), THIRD(3, true), FOURTH(4, false), FIFTH(5, false), SIXTH(6, false), SEVENTH(7, false), EIGHTH(8, false), NINTH(9, false), TENTH(10, true),
    ELEVENTH(11, false), TWELFTH(12, false), THIRTEENTH(13, false), FOURTEENTH(14, false), FIFTEENTH(15, false), SIXTEENTH(16, false), SEVENTEENTH(17, true), EIGHTEENTH(18, false), NINETEENTH(19, false), TWENTIETH(20, false),
    TWENTY_FIRST(21, false), TWENTY_SECOND(22, false), TWENTY_THIRD(23, false), TWENTY_FOURTH(24, true), TWENTY_FIFTH(25, true), TWENTY_SIXTH(26, false), TWENTY_SEVENTH(27, false), TWENTY_EIGHTH(28, false), TWENTY_NINTH(29, false), THIRTIETH(30, false),
    THIRTY_FIRST(31, true);

    private static final int YEAR = 2023, MONTH = 12;
    private static final Map<Integer, Calendar> INTEGER_TO_CALENDAR = Arrays.stream(values())
            .collect(Collectors.toMap(Calendar::getDay, value -> value));
    private final int day;
    private final boolean star;

    public static LocalDate convertIntegerToLocalDate(int day) {
        validateDay(day);
        return LocalDate.of(YEAR, MONTH, INTEGER_TO_CALENDAR.get(day).getDay());
    }

    public static boolean isStar(int day) {
        return INTEGER_TO_CALENDAR.get(day).star;
    }

    public static boolean contains(int day) {
        return INTEGER_TO_CALENDAR.containsKey(day);
    }

    private static void validateDay(int day) {
        if (!contains(day)) {
            throw new IllegalStateException();
        }
    }

    Calendar(int day, boolean star) {
        this.day = day;
        this.star = star;
    }

    public int getDay() {
        return day;
    }
    public DayType getDayType() {
        return DayType.getDayType(getDayOfWeek());
    }

    public long calculateDaysFromFirstDay() {
        LocalDate firstDay = LocalDate.of(YEAR, MONTH, FIRST_DAY);
        LocalDate today = LocalDate.of(YEAR, MONTH, day);
        return ChronoUnit.DAYS.between(firstDay, today);
    }

    private DayOfWeek getDayOfWeek() {
        LocalDate date = LocalDate.of(YEAR, MONTH, day);
        return date.getDayOfWeek();
    }

    @Override
    public String toString() {
        return String.valueOf(MONTH) + "월 " + String.valueOf(day) + "일";
    }
}
