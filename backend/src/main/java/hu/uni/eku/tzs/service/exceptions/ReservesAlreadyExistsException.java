package hu.uni.eku.tzs.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public class ReservesAlreadyExistsException extends Exception{

    public ReservesAlreadyExistsException() {
    }

    public ReservesAlreadyExistsException(String message) {
        super(message);
    }

    public ReservesAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservesAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public ReservesAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
