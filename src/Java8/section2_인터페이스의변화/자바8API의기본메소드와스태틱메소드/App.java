package Java8.section2_인터페이스의변화.자바8API의기본메소드와스태틱메소드;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("hyj");
        names.add("lsh");
        names.add("toby");
        names.add("foo");
        names.add("study");

        names.forEach(System.out::println);

        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("================");
        while(spliterator1.tryAdvance(System.out::println));

        names.removeIf(s -> s.startsWith("h"));

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);
    }
}
