package christmas.domain;

import christmas.enums.Menu;
import christmas.enums.MenuCategory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isMenuDuplicate() {
        if (orders.size() != orders.stream().map(Order::getMenu).distinct().count()) {
            return true;
        }
        return false;
    }

    public boolean isMenuAllDrink() {
        if (orders.stream().map(Order::getMenu).allMatch(menu -> menu.getCategory().equals(MenuCategory.DRINK))) {
            return true;
        }
        return false;
    }

    public boolean isTotalCountOver(int maxTotal) {
        if (orders.stream().mapToInt(Order::getCount).sum() > maxTotal) {
            return true;
        }
        return false;
    }

    public Map<Menu, Integer> convertListToMap() {
        Map<Menu, Integer> orderMap = new LinkedHashMap<>();
        for(Order order : orders) {
            orderMap.put(order.getMenu(), order.getCount());
        }
        return Map.copyOf(orderMap);
    }
}
