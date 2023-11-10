package christmas.enums;

import java.time.DayOfWeek;

public enum DayType {
    WEEKDAY, WEEKEND;

    public static DayType getDayType(DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(DayOfWeek.FRIDAY)
                || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            return WEEKEND;
        }
        return WEEKDAY;
    }
}
