package by.krukouski.threaddemo.example1;

public class Example {

    String resource1 = "Resource1";
    String resource2 = "Resource2";
    public static Example example = new Example();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyRunnable1());
        Thread thread2 = new Thread(new MyRunnable2());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        synchronized (Example.example.resource1) {
            System.out.println("Lock resource 1 in " + Thread.currentThread().getName());

            try {
                Thread.sleep(100);

                synchronized (Example.example.resource2) {
                    System.out.println("Lock resource 2 in " + Thread.currentThread().getName());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        synchronized (Example.example.resource2) {
            System.out.println("Lock resource 2 in " + Thread.currentThread().getName());

            try {
                Thread.sleep(100);

                synchronized (Example.example.resource1) {
                    System.out.println("Lock resource 1 in " + Thread.currentThread().getName());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
