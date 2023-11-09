package christmas.view;

import christmas.enums.Menu;

import java.util.AbstractMap;
import java.util.Map;

public class InputParser {
    private final String OUTER_DELIMITER = ",", INNER_DELIMITER = "-";
    private final int NO_LIMIT = -1;

    public int parseInt(String number) {
        return Integer.parseInt(number);
    }

    public String[] outerSplit(String outer) {
        return outer.split(OUTER_DELIMITER, NO_LIMIT);
    }

    public Map.Entry<String, Integer> innerSplit(String inner) {
        int index = inner.indexOf(INNER_DELIMITER);
        validateNoDelimiter(index);

        String menu = inner.substring(0, index);
        int ea = parseInt(inner.substring(index + 1));

        return new AbstractMap.SimpleEntry<>(menu, ea);
    }

    private void validateNoDelimiter(int index) {
        if (index == -1) {
            throw new IllegalArgumentException();
        }
    }
}
