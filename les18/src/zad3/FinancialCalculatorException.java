package zad3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinancialCalculatorException {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            calculate();
        }
        catch (LimitException e){
            System.out.println(e.getDetailMessage());
        }
        // перехват исключения LimitException
    }

    public static double getInterest(final double rate, final int time, final double principal) {
        final double multiplier = Math.pow(1.0 + rate/100.0, time) - 1.0;
        return multiplier * principal;
    }

    public static int getIntLimited(String greeting, int attempts) {
        for (int counter = 0; counter < attempts; counter++) {
            try {
                System.out.println(greeting + " => ");
                try {
                    final int value = Integer.parseInt(scanner.nextLine());
                    if(value < 0)
                        throw new InputException("Введено отрицательное значение!");
                    return value;
                } catch (NumberFormatException exception) {
                    throw new InputException("Введено не число!");
                }
            } catch (InputException exception) {
                System.out.println("Ошибка ввода: " + exception.getMessage());
            }
        }
        throw new LimitException("Превышен лимит ошибок ввода",attempts);
    }

    public static double getDoubleLimited(String greeting, int attempts) {
        for (int counter = 0; counter < attempts; counter++) {
            try {
                System.out.println(greeting + " => ");
                // добавьте недостающий код
                try {
                    final double value = Double.parseDouble(scanner.nextLine());
                    if(value < 0)
                        throw new InputException("Введено отрицательное значение!");
                    return value;
                } catch (NumberFormatException exception) {
                    throw new InputException("Введено не число!");
                }
            } catch (InputException exception) {
                System.out.println("Ошибка ввода: " + exception.getMessage());
            }
        }
        throw new LimitException("Превышен лимит ошибок ввода",attempts);
    }

    public static void calculate() {
        final double rate = getDoubleLimited("Введите ставку", 3);
        final double principal = getDoubleLimited("Введите размер вклада", 3);
        final int time = getIntLimited("Введите срок вклада в месяцах", 5);
        System.out.println("Ваша выгода = " + getInterest(rate, time, principal));
    }
}
class LimitException extends RuntimeException {
    public LimitException() {
        super();
    }

    String message;
    public LimitException(String message) {
        super(message);
    }

    public LimitException(String message, Integer countTries) {
        super(message);
        this.countTries = countTries;
        this.message = message;
    }

    public Integer countTries;

    public String getDetailMessage(){
        return message + ": " + countTries;
    }

}

class InputException extends Exception {
    public InputException() {
        super();
    }

    public InputException(String message) {
        super(message);
    }
}