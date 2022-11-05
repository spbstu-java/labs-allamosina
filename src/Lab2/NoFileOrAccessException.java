package Lab2;

import java.io.IOException;

public class NoFileOrAccessException extends IOException {
    public NoFileOrAccessException(String message) {
        super(message);
    }
}
