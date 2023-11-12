package christmas.domain.order;

import christmas.domain.money.Money;
import christmas.enums.Menu;
import christmas.enums.MenuCategory;

import java.util.Map;

public class OrdersMenuCount {
    private static final int MAX_TOTAL_COUNT = 20;
    private final Map<Menu, Integer> ordersMenuCount;

    public OrdersMenuCount(Map<Menu, Integer> ordersMenuCount) {
        validateKeysContainsNotDrink(ordersMenuCount);
        validateTotalValuesNotOverMaxTotalCount(ordersMenuCount);

        this.ordersMenuCount = ordersMenuCount;
    }

    public Money calculateOrderTotal() {
        Money orderTotal = Money.ZERO;

        for (Map.Entry<Menu, Integer> order : ordersMenuCount.entrySet()) {
            Menu menu = order.getKey();
            int count = order.getValue();

            orderTotal = orderTotal.add(menu.multiply(count));
        }

        return orderTotal;
    }

    public int getDesertCount() {
        return ordersMenuCount.keySet().stream()
                .filter(key -> key.getCategory().equals(MenuCategory.DESSERT))
                .mapToInt(ordersMenuCount::get)
                .sum();
    }

    public int getMainCount() {
        return ordersMenuCount.keySet().stream()
                .filter(key -> key.getCategory().equals(MenuCategory.MAIN))
                .mapToInt(ordersMenuCount::get)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder ordersBuilder = new StringBuilder("<주문 메뉴>").append(System.lineSeparator());

        for (Map.Entry<Menu, Integer> order : ordersMenuCount.entrySet()) {
            ordersBuilder.append(order.getKey().getName())
                    .append(" ")
                    .append(order.getValue())
                    .append("개")
                    .append(System.lineSeparator());
        }

        return ordersBuilder.toString();
    }

    private void validateKeysContainsNotDrink(Map<Menu, Integer> ordersMenuCount) {
        if (ordersMenuCount.keySet().stream().allMatch(key -> key.getCategory().equals(MenuCategory.DRINK))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTotalValuesNotOverMaxTotalCount(Map<Menu, Integer> ordersMenuCount) {
        if (ordersMenuCount.values().stream().mapToInt(Integer::intValue).sum() > MAX_TOTAL_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
