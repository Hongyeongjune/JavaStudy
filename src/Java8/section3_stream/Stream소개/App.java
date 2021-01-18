package Java8.section3_stream.Stream소개;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("hyj");
        names.add("lsh");
        names.add("toby");
        names.add("foo");
        names.add("study");

        List<String> collection = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("=======================");
        collection.forEach(System.out::println);

        List<String> collect = names.stream()
                .map((s) -> {
                    System.out.println(s);
                    return s.toUpperCase();
                }).collect(Collectors.toList());

        System.out.println("=======================");
        collect.forEach(System.out::println);

        System.out.println("=======================");
        names.forEach(System.out::println);
    }
}
