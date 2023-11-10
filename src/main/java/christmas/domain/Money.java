package christmas.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Money {
    public static final Money ZERO = new Money(BigDecimal.valueOf(0L)),
            TEN_THOUSAND = new Money(BigDecimal.valueOf(10_000L)),
            HUNDRED_TWENTY_THOUSAND = new Money(BigDecimal.valueOf(120_000L));
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money(long amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public Money add(Money money) {
        BigDecimal result = amount.add(money.amount);
        return new Money(result);
    }

    public Money multiply(int count) {
        BigDecimal result = amount.multiply(BigDecimal.valueOf(count));
        return new Money(result);
    }

    @Override
    public String toString() {
        DecimalFormat moneyFormat = new DecimalFormat("###,###");
        return moneyFormat.format(amount);
    }
}
