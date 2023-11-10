package christmas.domain;

import christmas.enums.Menu;
import christmas.enums.MenuCategory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private final Map<Menu, Integer> orders;

    public Orders(List<Map.Entry<String, Integer>> orders) {
        validateKeysExistMenu(orders);
        validateKeysNotDuplicate(orders);
        validateKeysContainsNotDrink(orders);
        validateValuesNotZeroNegative(orders);
        validateTotalValuesNotOverTwenty(orders);

        this.orders = convertListToMap(orders);
    }

    private void validateKeysExistMenu(List<Map.Entry<String, Integer>> orders) {
        for(Map.Entry<String, Integer> order : orders) {
            if (!Menu.contains(order.getKey())) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateKeysNotDuplicate(List<Map.Entry<String, Integer>> orders) {
        if (orders.size() != orders.stream().map(Map.Entry::getKey).distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateKeysContainsNotDrink(List<Map.Entry<String, Integer>> orders) {
        if (orders.stream().map(Map.Entry::getKey).allMatch(menu -> Menu.convertStringToCategory(menu).equals(MenuCategory.DRINK))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateValuesNotZeroNegative(List<Map.Entry<String, Integer>> orders) {
        if (orders.stream().map(Map.Entry::getValue).anyMatch(counts -> counts <= 0)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTotalValuesNotOverTwenty(List<Map.Entry<String, Integer>> orders) {
        if (orders.stream().mapToInt(Map.Entry::getValue).sum() > 20) {
            throw new IllegalArgumentException();
        }
    }

    private Map<Menu, Integer> convertListToMap(List<Map.Entry<String, Integer>> orders) {
        Map<Menu, Integer> orderMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> order : orders) {
            orderMap.put(Menu.convertStringToMenu(order.getKey()), order.getValue());
        }
        return orderMap;
    }
}
