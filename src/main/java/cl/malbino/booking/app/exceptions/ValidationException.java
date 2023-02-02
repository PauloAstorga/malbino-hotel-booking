package cl.malbino.booking.app.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ValidationException extends Exception{

    public ValidationException(String message) {
        super(message);
    }

}
