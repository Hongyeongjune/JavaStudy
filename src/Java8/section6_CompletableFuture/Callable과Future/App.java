package Java8.section6_CompletableFuture.Callable과Future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> future = executorService.submit(hello);
        System.out.println(future.isDone());
        System.out.println("Started!!");

        //블록킹 콜
        future.get();

        // true -> 종료
        // false -> 종료x 지만 get()을 사용할 수는 없음
        future.cancel(true);

        System.out.println(future.isDone());
        System.out.println("End!!");

        executorService.shutdown();

        ExecutorService service = Executors.newFixedThreadPool(4);
        Callable<String> one = () -> {
            Thread.sleep(2000L);
            return "One";
        };

        Callable<String> two = () -> {
            Thread.sleep(3000L);
            return "Two";
        };

        Callable<String> three = () -> {
            Thread.sleep(1000L);
            return "Three";
        };

        List<Future<String>> futures = service.invokeAll(Arrays.asList(one, two, three));
        for(Future<String> f : futures) {
            System.out.println(f.get());
        }

        String s = service.invokeAny(Arrays.asList(one, two, three));
        System.out.println(s);

        service.shutdown();



    }
}
