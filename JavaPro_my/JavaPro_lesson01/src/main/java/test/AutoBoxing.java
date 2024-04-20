package test;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxing {
    public static void main(String[] args) {

        int i = 7;                  // просто объект
        Integer integer = 7;        // объект с которым мы можем вызывать методы

        List<Integer> numbers = new ArrayList<>();

        // Autoboxing  int -> Integer
        integer = i;

        // без autoboxing
        integer = new Integer(i);

        // Unboxing Integer -> int
        i= integer;

        // без unboxing
        i = integer.intValue();


    }
}
