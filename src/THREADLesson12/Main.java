package THREADLesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Port port=new Port();
        Semaphore writingSemaphore = new Semaphore(1);
        Semaphore readingSemaphore = new Semaphore(3);


        List<Thread> dockWriter = new ArrayList<>();

        List<Send> sends= new ArrayList<>();
        sends.add(new Send(10));
        sends.add(new Send(10));
        sends.add(new Send(10));
        sends.add(new Send(10));
        sends.add(new Send(10));


        List<Ship> ships =new ArrayList<>();
        ships.add(new Ship(70,70,"первый"));
        ships.add(new Ship(40,10,"второй"));
        ships.add(new Ship(30,50,"третий"));
        ships.add(new Ship(10,20,"четвертый"));
        ships.add(new Ship(100,60,"пятый"));

        final int[] a = {0};


        for (final int[] i = {0}; i[0] <5; i[0]++){
            Thread Write =new Thread(new Runnable() {
              @Override
                public void run() {
                    try {
                         System.out.println("Запустился поток "+Thread.currentThread().getName()+" и ждет очереди");
                        writingSemaphore.acquire();
                        System.out.println("Прошел поток "+Thread.currentThread().getName());
                        int count= port.getValueOfContainers()+ships.get(a[0]).getContainers();
                        if (count<=port.getValue()){

                            port.setValueOfContainers(port.getValueOfContainers()+ships.get(a[0]).getContainers());
                            System.out.println("загрузился "+ ships.get(a[0]));
                            System.out.println("Текущее кол-во контейнеров "+port.getValueOfContainers());

                        }else System.out.println("слишком много контейнеров на складе порта");
                                System.out.println("Корабль не может разгрузиться  "+ ships.get(a[0]));

                         } catch (InterruptedException e) {
                        e.printStackTrace();
                         } finally {
                        a[0]++;
                        System.out.println(a[0]);
                        System.out.println("Освободиллся "+Thread.currentThread().getName());
                        writingSemaphore.release();
                    }

                }
            });
            Write.setName("write "+ i[0]);
            dockWriter.add(Write);
            System.out.println();
        }

        for (Thread thread : dockWriter) {
            thread.start();
        }

        for (Thread thread : dockWriter) {
            thread.join();
        }

        System.out.println("итого в порту "+port.getValueOfContainers());
    }




}