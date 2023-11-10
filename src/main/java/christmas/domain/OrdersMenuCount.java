package christmas.domain;

import christmas.enums.Menu;

import java.util.Map;

public class OrdersMenuCount {
    private static final int MAX_TOTAL = 20;
    private final Map<Menu, Integer> orders;

    public OrdersMenuCount(Orders orders) {
        validateMenuNotDuplicate(orders);
        validateMenuContainsNotDrink(orders);
        validateTotalCountNotOverMaxTotal(orders);

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

    private void validateMenuNotDuplicate(Orders orders) {
        if (orders.isMenuDuplicate()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMenuContainsNotDrink(Orders orders) {
        if (orders.isMenuAllDrink()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTotalCountNotOverMaxTotal(Orders orders) {
        if (orders.isTotalCountOver(MAX_TOTAL)) {
            throw new IllegalArgumentException();
        }
    }

    private Map<Menu, Integer> convertListToMap(Orders orders) {
        return orders.convertListToMap();
    }
}
