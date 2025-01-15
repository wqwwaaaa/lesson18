package zad4.util;
public class IncorrectInputException extends Exception{
    public IncorrectInputException() {
        super();
    }

    public IncorrectInputException(String message) {
        super(message);
    }
}