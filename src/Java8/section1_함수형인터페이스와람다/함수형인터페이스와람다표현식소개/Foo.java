package Java8.section1_함수형인터페이스와람다.함수형인터페이스와람다표현식소개;

public class Foo {
    public static void main(String[] args) {

        int baseNumber = 10;

        //익명 내부 클래스
        RunSomething runSomething = number -> number + baseNumber;

    }
}
