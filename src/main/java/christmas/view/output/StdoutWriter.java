package christmas.view.output;

public class StdoutWriter implements Writer {
    @Override
    public void write(Object object) {
        System.out.println(object);
    }
}
