package christmas.view;

import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.enums.Menu;

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

    public Map<Menu, Integer> innersSplit(List<String> inners) {
        Orders orders = new Orders(inners.stream().map(this::innerSplit).toList());
        return orders.convertListToMap();
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
