package zad2;

class UserInputException extends Exception{
    public UserInputException() {
        super();
    }
    public UserInputException(String message) {
        super(message);
    }
}
public class Practicum {
    public static void main(final String[] args) {
        final UserInputException userInputException = new UserInputException("Ошибка ввода!");
        System.out.println(userInputException.getMessage());
    }
}