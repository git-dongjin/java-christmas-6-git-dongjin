package christmas;

import christmas.controller.PromotionController;
import christmas.view.input.ConsoleReader;
import christmas.view.output.StdoutWriter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PromotionController promotionController = new PromotionController(new ConsoleReader(), new StdoutWriter());
        promotionController.run();
    }
}
