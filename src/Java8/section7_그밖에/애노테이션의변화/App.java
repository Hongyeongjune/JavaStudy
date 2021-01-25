package Java8.section7_그밖에.애노테이션의변화;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("간장")
public class App {
    public static void main(@Chicken String[] args) throws @Chicken RuntimeException {
        List<@Chicken String> names = Arrays.asList("hong");

        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> System.out.println(c.value()));

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> System.out.println(c.value()));
    }

    static class FeelsLikeChicken<@Chicken T> {

        public static <@Chicken C> void print(@Chicken C c) {

        }
    }
}
