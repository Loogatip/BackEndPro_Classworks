package test;

import app.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {

    public static void main(String[] args) {

        int i = 7;
        Integer integer = 7;

        List<Integer> numbers = new ArrayList<>();

        // Autoboxing int -> Integer
        integer = i;

        // Как делали раньше, пока не было автоупаковки
        integer = new Integer(i);

        // Unboxing Integer -> int
        i = integer;

        // Как делали раньше, пока не было автораспаковки
        i = integer.intValue();

        User user = new User("test@test.com", "111");

        System.out.println();
    }
}