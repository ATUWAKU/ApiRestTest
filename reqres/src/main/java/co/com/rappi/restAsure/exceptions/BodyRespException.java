package co.com.rappi.restAsure.exceptions;

import static co.com.rappi.restAsure.utils.Constants.URLRESPONSE;

public class BodyRespException extends Error {

    public BodyRespException(String message, Throwable cause) {
        super(message, cause);
    }
}
