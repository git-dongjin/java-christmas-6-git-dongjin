package christmas.domain.order;

import christmas.enums.Menu;

import java.util.List;
import java.util.Map;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        Order.validateMenuNotDuplicate(orders);

        this.orders = orders;
    }

    public Map<Menu, Integer> convertListToMap() {
        return Order.convertListToMap(orders);
    }
}
