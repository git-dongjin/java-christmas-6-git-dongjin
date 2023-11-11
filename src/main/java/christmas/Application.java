package christmas;


import christmas.controller.PromotionHandler;
import christmas.view.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PromotionHandler promotionHandler = new PromotionHandler(new InputView(new ConsoleReader(), new InputParser(), new OutputView(new StdoutWriter())), new OutputView(new StdoutWriter()));
        promotionHandler.run();
    }
}
