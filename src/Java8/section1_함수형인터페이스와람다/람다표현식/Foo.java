package Java8.section1_함수형인터페이스와람다.람다표현식;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {

        int baseNumber = 10;

        // 로컬 클래스
        class localClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11이 나온다.
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 파라미터 값이 나온다.
            }
        };

        // 람다
        IntConsumer printInteger = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInteger.accept(10);
    }
}
