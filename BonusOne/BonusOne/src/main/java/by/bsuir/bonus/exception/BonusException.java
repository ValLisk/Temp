package by.bsuir.bonus.exception;

public class BonusException extends Exception{
    public BonusException() {
        super();
    }

    public BonusException(String message) {
        super(message);
    }

    public BonusException(String message, Throwable cause) {
        super(message, cause);
    }

    public BonusException(Throwable cause) {
        super(cause);
    }
}
