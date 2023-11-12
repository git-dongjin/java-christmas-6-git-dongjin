package christmas.domain.order;

import christmas.enums.Menu;
import org.mockito.internal.matchers.Or;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Menu menu;
    private final int count;

    public static Map<Menu, Integer> convertListToMap(List<Order> orders) {
        validateMenuNotDuplicates(orders);
        Map<Menu, Integer> orderMap = new LinkedHashMap<>();

        for (Order order : orders) {
            orderMap.put(order.menu, order.count);
        }

        return Map.copyOf(orderMap);
    }

    public static void validateMenuNotDuplicate(List<Order> orders) {
        if (orders.size() != orders.stream().map(order -> order.menu).distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateMenuNotDuplicates(List<Order> orders) {
        if (orders.size() != orders.stream().map(order -> order.menu).distinct().count()) {
            throw new IllegalStateException();
        }
    }

    public Order(String menu, int count) {
        validateExistMenu(menu);
        validateNotZeroNegative(count);
        this.menu = convertStringToMenu(menu);
        this.count = count;
    }

    private void validateExistMenu(String menu) {
        if (!Menu.contains(menu)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotZeroNegative(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private Menu convertStringToMenu(String menu) {
        return Menu.convertStringToMenu(menu);
    }
}
