package exceptions;

public class InvalidUserDataException extends Exception {

    public InvalidUserDataException() {
        super("Ошибка авторизации");
    }
}
