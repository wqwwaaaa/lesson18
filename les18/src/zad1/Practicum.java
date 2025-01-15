package zad1;

import java.net.URI;
import java.net.URISyntaxException;

public class Practicum {
    public static void main(String[] args) {
        System.out.println(parseStringToURI("https://ya.ru"));
        System.out.println(parseStringToURI("\\\\"));
        System.out.println(parseStringToURI(null));
    }

    public static URI parseStringToURI(final String input) {
        try {
            return new URI(input);
        } catch (Throwable e) {
            return null;
        }

    }
}

