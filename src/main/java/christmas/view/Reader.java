package christmas.view;

import java.io.Closeable;

public interface Reader extends Closeable {
    String read();

    @Override
    void close();
}
