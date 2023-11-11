package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.input.Reader;

public class ConsoleReader implements Reader {
    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
