package christmas.view;

import christmas.domain.Day;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, Integer> readOrders() {
        while (true) {
            try {
                outputView.printReadMenuEa();
                String input = reader.readLine();
                String[] outerSplit = inputParser.outerSplit(input);
                return Arrays.stream(outerSplit).map(inputParser::innerSplit)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            } catch (IllegalArgumentException e) {
                outputView.printReadMenuEaError();
            }
        }
    }
}
