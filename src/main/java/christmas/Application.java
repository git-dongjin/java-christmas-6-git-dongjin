package christmas;


import christmas.controller.PromotionHandler;
import christmas.view.input.ConsoleReader;
import christmas.view.input.InputParser;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;
import christmas.view.output.StdoutWriter;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PromotionHandler promotionHandler = new PromotionHandler(new InputView(new ConsoleReader(), new InputParser(), new OutputView(new StdoutWriter())), new OutputView(new StdoutWriter()));
        promotionHandler.run();
    }
}
