package hu.uni.eku.tzs.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class CampsAlreadyExistsException extends Exception {

    public CampsAlreadyExistsException() {
    }

    public CampsAlreadyExistsException(String message) {
        super(message);
    }

    public CampsAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CampsAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public CampsAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
