package christmas.enums;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.enums.MenuCategory.*;

public enum Menu {
    SOUP(APPETIZER, "양송이수프", BigDecimal.valueOf(6_000L)), TAPAS(APPETIZER, "타파스", BigDecimal.valueOf(5_500L)), CAESAR_SALAD(APPETIZER, "시저샐러드", BigDecimal.valueOf(8_000L)),
    T_BONE_STEAK(MAIN, "티본스테이크", BigDecimal.valueOf(55_000L)), BARBECUE_LIBS(MAIN, "바비큐립", BigDecimal.valueOf(54_000L)), SEAFOOD_PASTA(MAIN, "해산물파스타", BigDecimal.valueOf(35_000L)), CHRISTMAS_PASTA(MAIN, "크리스마스파스타", BigDecimal.valueOf(25_000L)),
    CHOCOLATE_CAKE(DESSERT, "초코케이크", BigDecimal.valueOf(15_000L)), ICE_CREAM(DESSERT, "아이스크림", BigDecimal.valueOf(5_000L)),
    ZERO_COKE(DRINK, "제로콜라", BigDecimal.valueOf(3_000L)), RED_WINE(DRINK, "레드와인", BigDecimal.valueOf(60_000L)), CHAMPAGNE(DRINK, "샴페인", BigDecimal.valueOf(25_000L));

    private static final Map<String, Menu> STRING_TO_MENU = Arrays.stream(values()).collect(Collectors.toMap(Menu::getName, value -> value));
    private final MenuCategory category;
    private final String name;
    private final BigDecimal price;

    public static Menu convertStringToMenu(String name) {
        validateName(name);
        return STRING_TO_MENU.get(name);
    }

    public static boolean contains(String name) {
        return STRING_TO_MENU.containsKey(name);
    }

    private static void validateName(String name) {
        if (!contains(name)) {
            throw new IllegalArgumentException();
        }
    }

    Menu(MenuCategory category, String name, BigDecimal price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
