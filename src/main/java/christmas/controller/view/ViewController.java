package christmas.controller.view;

import christmas.domain.day.Day;
import christmas.domain.order.OrdersMenuCount;
import christmas.view.input.InputView;
import christmas.view.input.Reader;
import christmas.view.output.OutputView;
import christmas.view.output.Writer;

public class ViewController {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewController(Reader reader, Writer writer) {
        this.outputView = new OutputView(writer);
        this.inputView = new InputView(reader, outputView);
    }

    public Day inputDate() {
        return inputView.readDate();
    }

    public OrdersMenuCount inputOrdersMenuCount() {
        return inputView.readOrdersMenuCount();
    }

    public void outputNewLine() {
        outputView.printNewLine();
    }

    public void outputWelcome() {
        outputView.printWelcome();
    }

    public void outputReadDate() {
        outputView.printReadDate();
    }

    public void outputReadOrdersMenuCount() {
        outputView.printReadOrdersMenuCount();
    }

    public void outputReadDateError() {
        outputView.printReadDateError();
    }

    public void outputReadOrdersMenuCountError() {
        outputView.printReadOrdersMenuCountError();
    }

    public void output(Object object) {
        outputView.print(object);
    }
}
