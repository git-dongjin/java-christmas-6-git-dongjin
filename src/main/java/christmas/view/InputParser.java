package christmas.view;

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

    public List<Map.Entry<String, Integer>> innersSplit(List<String> inners) {
        List<Map.Entry<String, Integer>> orders = new ArrayList<>();

        for (String inner : inners) {
            Map.Entry<String, Integer> order = innerSplit(inner);
            orders.add(order);
        }

        return orders;
    }

    private Map.Entry<String, Integer> innerSplit(String inner) {
        int index = inner.indexOf(INNER_DELIMITER);
        validateNoDelimiter(index);

        String menu = inner.substring(0, index);
        int counts = parseInt(inner.substring(index + 1));

        return new AbstractMap.SimpleEntry<>(menu, counts);
    }

    private void validateNoDelimiter(int index) {
        if (index == -1) {
            throw new IllegalArgumentException();
        }
    }
}
