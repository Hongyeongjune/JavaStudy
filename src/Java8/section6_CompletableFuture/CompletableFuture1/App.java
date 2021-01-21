package Java8.section6_CompletableFuture.CompletableFuture1;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 일반
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("hong");
        System.out.println("General : " + future.get());

        // 팩토리메소드화
        CompletableFuture<String> factoryMethodFuture = CompletableFuture.completedFuture("hong");
        System.out.println("FactoryMethod : " + factoryMethodFuture.get());

        // 리턴값없음
        CompletableFuture<Void> noReturn = CompletableFuture.runAsync(() -> {
            System.out.println("No Return : " + Thread.currentThread().getName());
        });
        noReturn.get();

        // 리턴값 있음
        CompletableFuture<String> existReturn = CompletableFuture.supplyAsync(() -> {
            System.out.println("Exist Return : " + Thread.currentThread().getName());
            return "hello";
        });
        System.out.println("Exist Return : " + existReturn.get());

        // 콜백처리 -> 리턴값 받아서 다른값으로 처리
        CompletableFuture<String> callBack = CompletableFuture.supplyAsync(() -> {
            System.out.println("CallBack : " + Thread.currentThread().getName());
            return "callback";
        }).thenApply((s) -> {
            System.out.println("CallBack : " +Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println("CallBack : " +callBack.get());

        // 리턴없는 콜백처리
        CompletableFuture<Void> noReturnCallBack = CompletableFuture.supplyAsync(() -> {
            System.out.println("No Return : " + Thread.currentThread().getName());
            return "noreturn";
        }).thenAccept((s) -> {
            System.out.println("No Return : " +Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        System.out.println("No Return : " +noReturnCallBack.get());

        // 리턴값을 사용하지 않고 다른 작업 실행
        CompletableFuture<Void> noParamCallBack = CompletableFuture.supplyAsync(() -> {
            System.out.println("No Param : " + Thread.currentThread().getName());
            return "noparam";
        }).thenRun(()-> {
            System.out.println("No Param : " +Thread.currentThread().getName());
        });

        System.out.println("No Param : " +noParamCallBack.get());

        // ExecutorService 를 인자로 줄 수 있다.
        // 우리가 사용하는 Thread Pool 을 이용하여 처리한다.
        ExecutorService service = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> pool = CompletableFuture.supplyAsync(() -> {
            System.out.println("Pool : " + Thread.currentThread().getName());
            return "pool";
        }, service).thenRunAsync(() -> {
            System.out.println("Pool : " + Thread.currentThread().getName());
        }, service);

        pool.get();
        service.shutdown();
    }
}
