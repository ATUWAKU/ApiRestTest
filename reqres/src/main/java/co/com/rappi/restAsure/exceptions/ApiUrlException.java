package co.com.rappi.restAsure.exceptions;

public class ApiUrlException extends RuntimeException{

    public ApiUrlException() {
        super("Api no contemplado en el sistema");
    }
}
