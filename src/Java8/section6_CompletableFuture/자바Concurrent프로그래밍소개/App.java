package Java8.section6_CompletableFuture.자바Concurrent프로그래밍소개;

public class App {

    public static void main(String[] args) throws InterruptedException {
        // main Thread
        System.out.println(Thread.currentThread().getName());

        // 상속
        // Thread 의 순서는 보장을 할 수가 없다.
        MyThread myThread = new MyThread();
        myThread.start();


        Thread thread = new Thread(() -> {

            while(true) {
                System.out.println("람다 Thread : " + Thread.currentThread().getName());
                // 다른 쓰레드에게 우선권이 부여된다.
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }

        });
        thread.start();

        System.out.println("Hello " + Thread.currentThread().getName());

        Thread.sleep(3000L);
        thread.interrupt();

        Thread thread1 = new Thread(() -> {
            System.out.println("람다 Thread1 : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        thread1.join();
        System.out.println(thread1 + " is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("상속 Thread : " + Thread.currentThread().getName());
        }
    }
}
