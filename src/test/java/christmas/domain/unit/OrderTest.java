package christmas.domain.unit;

import christmas.enums.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    //티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
    private static final List<Order> ORDERS_NOT_DUPLICATE = List.of(
            new Order("티본스테이크", 1),
            new Order("바비큐립", 1),
            new Order("초코케이크", 2),
            new Order("제로콜라", 1)
    ),
    ORDERS_DUPLICATE = List.of(
            new Order("티본스테이크", 1),
            new Order("티본스테이크", 6),
            new Order("제로콜라", 4)
    );
    private Order order;

    @BeforeEach
    void setUp() {
    }

    @Test
    void convertListToMap_성공() {
    }

    @Test
    void convertListToMap_중복주문() {

    }

    @Test
    void validateMenuNotDuplicate() {
    }
}