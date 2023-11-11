package christmas.view.input;

import christmas.domain.day.Day;
import christmas.domain.order.OrdersMenuCount;
import christmas.view.output.OutputView;

import java.util.List;

public class InputView {
    private final Reader reader;
    private final OutputView outputView;
    private final InputParser inputParser;

    public InputView(Reader reader, OutputView outputView) {
        this.reader = reader;
        this.outputView = outputView;
        this.inputParser = new InputParser();
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
