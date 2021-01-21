package Java8.section6_CompletableFuture.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        // 다음 작업이 들어올때 까지 대기함. -> 프로세스가 죽지않음
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("Thread execute : " + Thread.currentThread().getName());
        });
        executorService.submit(() -> {
            System.out.println("Thread submit : " + Thread.currentThread().getName());
        });

        // 명시적 제거 필요
        executorService.shutdown();

        // Thread Pool 을 두 개 만들어놓으면,
        // 두 Thread 를 먼저 작업하고 나머지 3개의 Thread 는 블록큐에 대기상태로 있는다.
        // Thread Pool 에 있는 Thread 가 작업을 완료하면 블록큐에 있던 Thread 가 Pool 로 들어간다.
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(getRunnable("Hello "));
        service.submit(getRunnable("hong "));
        service.submit(getRunnable("the "));
        service.submit(getRunnable("java "));
        service.submit(getRunnable("thread "));

        service.shutdown();

        // 스케줄 작업
        ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();
        scheduledService.schedule(getRunnable("scheduled "), 3, TimeUnit.SECONDS);

        // 2초마다 계속 출력이기 때문에 shutdown 을 넣으면 안된다.
        scheduledService.scheduleAtFixedRate(getRunnable("Rate "), 1, 2, TimeUnit.SECONDS);



    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
