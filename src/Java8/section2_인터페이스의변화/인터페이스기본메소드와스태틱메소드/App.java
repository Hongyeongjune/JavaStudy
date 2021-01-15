package Java8.section2_인터페이스의변화.인터페이스기본메소드와스태틱메소드;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("hyj");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
