package Java8.section2_인터페이스의변화.인터페이스기본메소드와스태틱메소드;

public interface Foo {

    void printName();

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    // Object가 제공하는 기능은 기본 메소드로 제공할 수 없다.
    // 구현체에서 재정의 해야한다.
//    default String toString() {
//
//    }

    // 추상메소드로 선언하는건 상관없다.
    String toString();

    String getName();

    static void printAnything() {
        System.out.println("Foo");
    }
}
