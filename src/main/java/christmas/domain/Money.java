package christmas.domain;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;

    public Money(long amount) {
        this.amount = BigDecimal.valueOf(amount);
    }
}
