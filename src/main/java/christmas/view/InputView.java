package christmas.view;

import christmas.domain.Day;
import christmas.domain.order.OrdersMenuCount;

import java.util.List;

public class InputView {
    private final Reader reader;
    private final InputParser inputParser;
    private final OutputView outputView;

    public InputView(Reader reader, InputParser inputParser, OutputView outputView) {
        this.reader = reader;
        this.inputParser = inputParser;
        this.outputView = outputView;
    }

    public Day readDate() {
        while (true) {
            try {
                outputView.printReadDate();
                String input = reader.readLine().strip();
                return new Day(inputParser.parseInt(input));
            } catch (IllegalArgumentException e) {
                outputView.printReadDateError();
            }
        }
    }

    public OrdersMenuCount readOrdersMenuCount() {
        while (true) {
            try {
                outputView.printReadOrdersMenuCount();
                String outer = reader.readLine();
                List<String> inners = inputParser.outerSplit(outer);
                return new OrdersMenuCount(inputParser.innersSplit(inners));
            } catch (IllegalArgumentException e) {
                outputView.printReadOrdersMenuCountError();
            }
        }
    }
}
