package christmas.enums;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum DecemberDay {
    FIRST(1, false), SECOND(2, false), THIRD(3, true), FOURTH(4, false), FIFTH(5, false), SIXTH(6, false), SEVENTH(7, false), EIGHTH(8, false), NINTH(9, false), TENTH(10, true),
    ELEVENTH(11, false), TWELFTH(12, false), THIRTEENTH(13, false), FOURTEENTH(14, false), FIFTEENTH(15, false), SIXTEENTH(16, false), SEVENTEENTH(17, true), EIGHTEENTH(18, false), NINETEENTH(19, false), TWENTIETH(20, false),
    TWENTY_FIRST(21, false), TWENTY_SECOND(22, false), TWENTY_THIRD(23, false), TWENTY_FOURTH(24, true), TWENTY_FIFTH(25, true), TWENTY_SIXTH(26, false), TWENTY_SEVENTH(27, false), TWENTY_EIGHTH(28, false), TWENTY_NINTH(29, false), THIRTIETH(30, false),
    THIRTY_FIRST(31, true);

    private static final int YEAR = 2023, MONTH = 12;
    private static final Map<Integer, DecemberDay> INTEGER_TO_DECEMBER_DAY = Arrays.stream(values())
            .collect(Collectors.toMap(DecemberDay::getDay, value -> value));
    private final int day;
    private final boolean star;

    public static DecemberDay convertIntegerToDecemberDay(int day) {
        validateDay(day);
        return INTEGER_TO_DECEMBER_DAY.get(day);
    }

    public static boolean contains(int day) {
        return INTEGER_TO_DECEMBER_DAY.containsKey(day);
    }

    private static void validateDay(int day) {
        if (!contains(day)) {
            throw new IllegalStateException();
        }
    }

    DecemberDay(int day, boolean star) {
        this.day = day;
        this.star = star;
    }

    public int getDay() {
        return day;
    }

    public boolean isStar() {
        return star;
    }
    public DayType getDayType() {
        return DayType.getDayType(getDayOfWeek());
    }

    private DayOfWeek getDayOfWeek() {
        LocalDate date = LocalDate.of(YEAR, MONTH, day);
        return date.getDayOfWeek();
    }
}
