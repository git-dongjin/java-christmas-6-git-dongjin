package christmas.domain.order;

import christmas.enums.Menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateMenuNotDuplicate(orders);

        this.orders = orders;
    }

    private void validateMenuNotDuplicate(List<Order> orders) {
        if (orders.size() != orders.stream().map(Order::getMenu).distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public Map<Menu, Integer> convertListToMap() {
        Map<Menu, Integer> orderMap = new LinkedHashMap<>();
        for(Order order : orders) {
            orderMap.put(order.getMenu(), order.getCount());
        }
        return Map.copyOf(orderMap);
    }
}
