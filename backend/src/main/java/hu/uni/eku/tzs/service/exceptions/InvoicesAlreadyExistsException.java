package hu.uni.eku.tzs.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class InvoicesAlreadyExistsException extends Exception {

    public InvoicesAlreadyExistsException() {
    }

    public InvoicesAlreadyExistsException(String message) {
        super(message);
    }

    public InvoicesAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvoicesAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public InvoicesAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}