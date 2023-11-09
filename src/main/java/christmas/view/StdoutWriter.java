package christmas.view;

public class StdoutWriter implements Writer {
    @Override
    public void write(String string) {
        System.out.println(string);
    }
}
