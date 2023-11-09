package christmas.enums;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum DecemberDay {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGHTH(8), NINTH(9), TENTH(10),
    ELEVENTH(11), TWELFTH(12), THIRTEENTH(13), FOURTEENTH(14), FIFTEENTH(15), SIXTEENTH(16), SEVENTEENTH(17), EIGHTEENTH(18), NINETEENTH(19), TWENTIETH(20),
    TWENTY_FIRST(21), TWENTY_SECOND(22), TWENTY_THIRD(23), TWENTY_FOURTH(24), TWENTY_FIFTH(25), TWENTY_SIXTH(26), TWENTY_SEVENTH(27), TWENTY_EIGHTH(28), TWENTY_NINTH(29), THIRTIETH(30),
    THIRTY_FIRST(31);

    private static final int YEAR = 2023, MONTH = 12;
    private static final Map<Integer, DecemberDay> INTEGER_TO_DECEMBER_DAY = Arrays.stream(values())
            .collect(Collectors.toMap(DecemberDay::getDay, value -> value));
    private final int day;

    public static DecemberDay integerToDecemberDay(int day) {
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

    DecemberDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        LocalDate date = LocalDate.of(YEAR, MONTH, day);
        return date.getDayOfWeek();
    }
}
