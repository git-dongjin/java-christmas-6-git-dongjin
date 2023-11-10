package christmas;

import christmas.view.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(new ConsoleReader(), new InputParser(), new OutputView(new StdoutWriter()));
        inputView.readOrdersMenuCount();
    }
}
