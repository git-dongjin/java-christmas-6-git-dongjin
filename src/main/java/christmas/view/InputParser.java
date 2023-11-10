package christmas.view;

import christmas.domain.Order;

import java.util.*;

public class InputParser {
    private final String OUTER_DELIMITER = ",", INNER_DELIMITER = "-";
    private final int NO_LIMIT = -1;

    public int parseInt(String number) {
        return Integer.parseInt(number);
    }

    public List<String> outerSplit(String outer) {
        return Arrays.stream(outer.split(OUTER_DELIMITER, NO_LIMIT)).map(String::strip).toList();
    }

    public List<Order> innersSplit(List<String> inners) {
        List<Order> orders = new ArrayList<>();

        for (String inner : inners) {
            Order order = innerSplit(inner);
            orders.add(order);
        }

        return orders;
    }

    private Order innerSplit(String inner) {
        int index = inner.indexOf(INNER_DELIMITER);
        validateNoDelimiter(index);

        String menu = inner.substring(0, index);
        int count = parseInt(inner.substring(index + 1));

        return new Order(menu, count);
    }

    private void validateNoDelimiter(int index) {
        if (index == -1) {
            throw new IllegalArgumentException();
        }
    }
}
