package christmas.domain.money;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Money implements Comparable<Money> {
    public static final Money ZERO = new Money(BigDecimal.valueOf(0L)),
            HUNDRED = new Money(BigDecimal.valueOf(100L)),
            THOUSAND = new Money(BigDecimal.valueOf(1_000L)),
            YEAR_AMOUNT = new Money(BigDecimal.valueOf(2_023L)),
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

    public Money multiply(long scalar) {
        BigDecimal result = amount.multiply(BigDecimal.valueOf(scalar));
        return new Money(result);
    }

    public Money negative() {
        return multiply(-1L);
    }

    @Override
    public int compareTo(Money other) {
        return this.amount.compareTo(other.amount);
    }

    @Override
    public String toString() {
        DecimalFormat moneyFormat = new DecimalFormat("###,###");
        return moneyFormat.format(amount);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Money money = (Money) other;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
