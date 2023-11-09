package christmas.domain;

import christmas.enums.Menu;

import java.util.Map;

public class Order {
    private final Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) {
        this.order = order;
    }
}
