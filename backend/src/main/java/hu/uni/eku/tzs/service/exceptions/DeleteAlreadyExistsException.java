package hu.uni.eku.tzs.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class DeleteAlreadyExistsException extends Exception {

    public DeleteAlreadyExistsException() {
    }

    public DeleteAlreadyExistsException(String message) {
        super(message);
    }

    public DeleteAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public DeleteAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}