package Java8.section7_그밖에.애노테이션의변화;

import java.lang.annotation.*;

// 컴파일 이후에도 JVM 에 의해서 참조가 가능합니다.
@Retention(RetentionPolicy.RUNTIME)
@Target({
        // 타입파라미터 선언시 사용할 수 있게 해줌
        ElementType.TYPE_PARAMETER,
        // 타입파라미터를 포함해서 타입을 선언하는 모든 곳에서 사용 가능
        ElementType.TYPE_USE
})
// 애노테이션을 중복사용 가능하게 함.
// 컨테이너가 가지고있는 Retention 과 Target 정보는 반드시 자기자신이 감쌀 애노테이션보다 더 넓어야한다.
@Repeatable(ChickenContainer.class)
public @interface Chicken {

    String value() default "후라이드";
}
