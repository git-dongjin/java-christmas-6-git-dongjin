package christmas.enums;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    BLANK("없음", 0);

    private final String name;
    private final int minProfit;

    Badge(String name, int minProfit) {
        this.name = name;
        this.minProfit = minProfit;
    }
}
