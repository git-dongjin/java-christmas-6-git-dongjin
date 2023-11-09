package christmas.view;

import christmas.domain.Day;

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
                String input = reader.readLine();
                return new Day(inputParser.parseInt(input));
            } catch (IllegalArgumentException e) {
                outputView.printReadDateError();
            }
        }
    }
}
