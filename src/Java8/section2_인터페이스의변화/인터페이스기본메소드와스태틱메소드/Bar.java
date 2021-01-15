package Java8.section2_인터페이스의변화.인터페이스기본메소드와스태틱메소드;

public interface Bar { //extends Foo {

    // Foo를 상속받고, Foo에 대한 기본메소드를 사용하고 싶지 않다면,
    // 기본메소드를 재정의하고, Bar를 받는 모든 구현체에서 구현을 해주어야한다.
    //void printNameUpperCase();

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println("BAR");
    }

}
