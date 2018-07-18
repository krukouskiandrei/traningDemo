package by.krukouski.threaddemo.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example {


    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService poll = Executors.newScheduledThreadPool(1);
        poll.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ping google.com");
            }
        }, 2, TimeUnit.SECONDS);

        poll.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ping yandex.ru");
            }
        }, 0, 2, TimeUnit.SECONDS);

        poll.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ping amazon.com");
            }
        }, 3, 2, TimeUnit.SECONDS);

        try {
            poll.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            poll.shutdownNow();
        }


    }


}
