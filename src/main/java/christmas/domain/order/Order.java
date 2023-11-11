package christmas.domain.order;

import christmas.enums.Menu;

public class Order {
    private final Menu menu;
    private final int count;

    public Order(String menu, int count) {
        validateExistMenu(menu);
        validateNotZeroNegative(count);
        this.menu = convertStringToMenu(menu);
        this.count = count;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
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
