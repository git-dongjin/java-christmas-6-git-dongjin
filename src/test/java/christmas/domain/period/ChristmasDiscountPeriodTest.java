package christmas.domain.period;

import christmas.domain.unit.Day;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ChristmasDiscountPeriodTest {
    private static long DAY_FROM_START = 10L;
    private static final Day START_DAY = Day.FIRST_DAY,
            END_DAY = Day.CHRISTMAS;
    private Day day;
    private ChristmasDiscountPeriod christmasDiscountPeriod;

    @BeforeEach
    void setUp() {
        day = mock(Day.class);
        christmasDiscountPeriod = new ChristmasDiscountPeriod(day);
    }

    @Test
    void isEventPeriod_이벤트기간() {
        when(day.isBefore(START_DAY)).thenReturn(false);
        when(day.isAfter(END_DAY)).thenReturn(false);

        assertThat(christmasDiscountPeriod.isEventPeriod()).isTrue();

        verify(day, times(1)).isBefore(START_DAY);
        verify(day, times(1)).isAfter(END_DAY);
    }

    @Test
    void isEventPeriod_이벤트기간전() {
        when(day.isBefore(START_DAY)).thenReturn(true);
        when(day.isAfter(END_DAY)).thenReturn(false);

        assertThat(christmasDiscountPeriod.isEventPeriod()).isFalse();

        verify(day, times(1)).isBefore(START_DAY);
        verify(day, times(0)).isAfter(END_DAY);
    }

    @Test
    void isEventPeriod_이벤트기간후() {
        when(day.isBefore(START_DAY)).thenReturn(false);
        when(day.isAfter(END_DAY)).thenReturn(true);

        assertThat(christmasDiscountPeriod.isEventPeriod()).isFalse();

        verify(day, times(1)).isBefore(START_DAY);
        verify(day, times(1)).isAfter(END_DAY);
    }

    @Test
    void calculateDaysFromStart() {
        when(day.betweenFrom(START_DAY)).thenReturn(DAY_FROM_START);

        assertThat(christmasDiscountPeriod.calculateDaysFromStart()).isEqualTo(DAY_FROM_START);

        verify(day, times(1)).betweenFrom(START_DAY);
    }
}