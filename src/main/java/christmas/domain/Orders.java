package christmas.domain;

import christmas.enums.Menu;
import christmas.enums.MenuCategory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private final Map<Menu, Integer> orders;

    public Orders(List<Order> orders) {
        validateMenuNotDuplicate(orders);
        validateMenuContainsNotDrink(orders);
        validateTotalCountNotOverTwenty(orders);

        this.orders = convertListToMap(orders);
    }

    public Money calculateOrderTotal() {
        Money orderTotal = Money.ZERO;

        for(Map.Entry<Menu, Integer> order : orders.entrySet()) {
            Money price = order.getKey().getPrice();
            int count = order.getValue();

            orderTotal = orderTotal.add(price.multiply(count));
        }

        return orderTotal;
    }

    @Override
    public String toString() {
        StringBuilder ordersBuilder = new StringBuilder("<주문 메뉴>").append(System.lineSeparator());

        for(Map.Entry<Menu, Integer> order : orders.entrySet()) {
            ordersBuilder.append(order.getKey().getName())
                    .append(order.getValue())
                    .append("개")
                    .append(System.lineSeparator());
        }

        return ordersBuilder.toString();
    }

    private void validateMenuNotDuplicate(List<Order> orders) {
        if (orders.size() != orders.stream().map(Order::getMenu).distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMenuContainsNotDrink(List<Order> orders) {
        if (orders.stream().map(Order::getMenu).allMatch(menu -> menu.getCategory().equals(MenuCategory.DRINK))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTotalCountNotOverTwenty(List<Order> orders) {
        if (orders.stream().mapToInt(Order::getCount).sum() > 20) {
            throw new IllegalArgumentException();
        }
    }

    private Map<Menu, Integer> convertListToMap(List<Order> orders) {
        Map<Menu, Integer> orderMap = new LinkedHashMap<>();
        for(Order order : orders) {
            orderMap.put(order.getMenu(), order.getCount());
        }
        return orderMap;
    }
}
