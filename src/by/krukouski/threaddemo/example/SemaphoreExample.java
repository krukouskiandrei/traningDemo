package by.krukouski.threaddemo.example;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {

        Semaphore writingSemaphore = new Semaphore(1);
        Semaphore readingSemaphore = new Semaphore(10);
        List<Thread> threads = new ArrayList<>();
        List<Object> resource = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            Thread writer = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting writing permit");
                        writingSemaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " has writing permit");
                        resource.add(new Object());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        writingSemaphore.release();
                        System.out.println("Goodbye from " + Thread.currentThread().getName());
                    }
                }
            });

            writer.setName("Writer #" + i);
            threads.add(writer);
            
        }

        for (int i = 0; i < 100; i++) {
            Thread reader = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting reading permit");
                        readingSemaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " has reading permit");
                        System.out.println("Number of elements: " + resource.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        readingSemaphore.release();
                        System.out.println("Goodbye from " + Thread.currentThread().getName());
                    }
                }
            });

            reader.setName("Reader #" + i);
            threads.add(reader);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Result: " + resource.size());


    }

}
