package domain;

import java.util.Objects;

public class Price {
    private static final Calculator CALCULATOR = Calculator.getInstance();
    private long value;

    public Price(long value) {
        validate(value);
        this.value = value;
    }

    public static Price zero() {
        return new Price(0L);
    }

    private void validate(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("금액은 0보다 큰 값이여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value == price.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public long divide(Price price) {
        return CALCULATOR.divide(this.value, price.value);
    }

    public Price add(Price price) {
        return new Price(CALCULATOR.add(this.value, price.value));
    }

    public Price minus(Price price) {
        return new Price(CALCULATOR.subtract(this.value, price.value));
    }

    public Price multiple(long number) {
        return new Price(CALCULATOR.multiple(this.value, number));
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public double divideWithDecimalPoint(Price price) {
        return CALCULATOR.divide(this.value, price.value);
    }
}