package Java8.section4_optional.OptionalAPI;

import Java8.section4_optional.Optional소개.Progress;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        System.out.println(present);

        OnlineClass onlineClass = spring.get();
        System.out.println(onlineClass.getTitle());

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        if(jpa.isPresent()) {
            onlineClass = jpa.get();
            System.out.println(onlineClass.getTitle());
        }

        jpa.ifPresent(oc -> System.out.println(oc.getTitle()));

        onlineClass = jpa.orElse(createNewClass());
        System.out.println(onlineClass.getTitle());

        onlineClass = spring.orElse(createNewClass());
        System.out.println(onlineClass.getTitle());

        onlineClass = jpa.orElseGet(App::createNewClass);
        System.out.println(onlineClass.getTitle());

        onlineClass = spring.orElseGet(App::createNewClass);
        System.out.println(onlineClass.getTitle());

        Optional<OnlineClass> onlineClass1 = spring
                .filter(OnlineClass::isClosed);
        System.out.println(onlineClass1.isPresent());

        Optional<Optional<Progress>> progress = spring.map(OnlineClass::getOptionalProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        progress1.orElseThrow();

        Optional<Progress> progress2 = spring.flatMap(OnlineClass::getOptionalProgress);

        onlineClass = jpa.orElseThrow(IllegalStateException::new);
        System.out.println(onlineClass.getTitle());
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }
}
