package co.com.rappi.restAsure.exceptions;

import static co.com.rappi.restAsure.utils.Constants.SUCCRESPCODE;

public class CodeResponseException extends Error {

    public CodeResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
