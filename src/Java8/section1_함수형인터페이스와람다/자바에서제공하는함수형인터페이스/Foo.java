package Java8.section1_함수형인터페이스와람다.자바에서제공하는함수형인터페이스;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {

        Function<Integer, Integer> plus10 = (integer) -> integer + 1;
        Function<Integer, Integer> multiply2 = (integer) -> integer * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);

        System.out.println(multiply2AndPlus10.apply(2));
        System.out.println(plus10AndMultiply2.apply(2));

        Consumer<Integer> printT = (integer) -> System.out.println(integer);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        Predicate<String> startsWithHYJ = (s) -> s.startsWith("HYJ");
        Predicate<Integer> isEven = (i) -> i%2==0;

        UnaryOperator<Integer> plus20 = (i) -> i + 20;
    }

}
