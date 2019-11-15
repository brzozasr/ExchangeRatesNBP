package exceptions;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class NBPDataException extends Exception {

    /**
     * Wyjątek otrzymany ze strony NBP
     *
     * @param message wiadomość wyjątku
     * @throws UnsupportedEncodingException kodowanie znaków nie jest obsługiwane.
     */
    public NBPDataException(String message) throws UnsupportedEncodingException {
        super(new String(message.getBytes(StandardCharsets.ISO_8859_1), "ISO-8859-2"));
    }
}
