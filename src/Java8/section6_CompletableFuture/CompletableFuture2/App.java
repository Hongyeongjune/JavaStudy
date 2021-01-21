package Java8.section6_CompletableFuture.CompletableFuture2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        });

        // 두 작업이 서로 이어져서 실행할 수 있게 함.
        CompletableFuture<String> future = hello.thenCompose(App::getWorld);
        System.out.println(future.get());


        CompletableFuture<String> naver = CompletableFuture.supplyAsync(() -> {
            System.out.println("naver " + Thread.currentThread().getName());
            return "naver";
        });

        CompletableFuture<String> amazon = CompletableFuture.supplyAsync(() -> {
            System.out.println("amazon " + Thread.currentThread().getName());
            return "amazon";
        });

        // 두 작업이 서로 의존성이 없는 상황에서 동시에 실행
        future = naver.thenCombine(amazon, (n, a) -> n + " " + a);
        System.out.println(future.get());

        // 여러 작업을 모두 실행하고 모든 작업 결과 콜백 실행
        List<CompletableFuture<String>> futures = Arrays.asList(naver, amazon);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<String>> completableFuture = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        completableFuture.get().forEach(System.out::println);

        // 가장 빨리 끝난 하나의 결과를 반환
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.anyOf(naver, amazon).thenAccept(System.out::println);
        voidCompletableFuture.get();

        // 예외처리
        boolean throwError = false;
        CompletableFuture<String> microsoft = CompletableFuture.supplyAsync(() -> {
            if(!throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("microsoft " + Thread.currentThread().getName());
            return "microsoft";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error";
        });

        System.out.println(microsoft.get());

        //예외처리
        CompletableFuture<String> spring = CompletableFuture.supplyAsync(() -> {
            if(!throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("spring " + Thread.currentThread().getName());
            return "spring";
        }).handle((result, ex) -> {
            if(ex != null) {
                System.out.println(ex);
                return "Error";
            }
            return result;
        });
    }

    // 두 작업이 서로 이어져서 실행할 수 있게 함.
    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
