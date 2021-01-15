package Java8.section2_인터페이스의변화.인터페이스기본메소드와스태틱메소드;

public class DefaultFoo implements Foo , Bar{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    // 재정의 가능
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
