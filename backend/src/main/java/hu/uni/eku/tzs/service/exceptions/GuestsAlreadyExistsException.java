package hu.uni.eku.tzs.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class GuestsAlreadyExistsException extends Exception {

    public GuestsAlreadyExistsException() {
    }

    public GuestsAlreadyExistsException(String message) {
        super(message);
    }

    public GuestsAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuestsAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public GuestsAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
