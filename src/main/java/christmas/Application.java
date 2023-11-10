package christmas;


import christmas.domain.Day;
import christmas.domain.UntilChristmasDiscount;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UntilChristmasDiscount untilChristmasDiscount = new UntilChristmasDiscount(new Day(26));
        System.out.println(untilChristmasDiscount);
    }
}
