package christmas.view;

public class StdoutWriter implements Writer {
    @Override
    public void write(Object object) {
        System.out.println(object);
    }
}
