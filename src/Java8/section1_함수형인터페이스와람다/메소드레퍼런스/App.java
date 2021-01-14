package Java8.section1_함수형인터페이스와람다.메소드레퍼런스;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("hello yj"));

        UnaryOperator<String> hi = Greeting::hi;

        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        Function<String, Greeting> yjGreeting = Greeting::new;
        Greeting yj = yjGreeting.apply("HYJ");
        System.out.println(yj.getName());

        String[] names = {"lsh" , "hyj"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
