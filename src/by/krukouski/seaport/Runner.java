package by.krukouski.seaport;

import by.krukouski.seaport.entity.Dock;
import by.krukouski.seaport.entity.Seaport;
import by.krukouski.seaport.entity.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private static final Integer COUNT_DOCKS = 3;
    private static final Integer COUNT_SHIPS = 20;
    private static final Integer SHIP_CARRYING = 50;
    private static final Integer SEAPORT_CAPACITY = 1_000;
    private static final String SEAPORT_NAME = "Belarus SEAPORT";
    private static final String SHIP_NAME = "SHIP_";


    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(COUNT_DOCKS);

        Seaport seaport = createSeaport();
        List<Dock> docks = createListOfDocks();
        seaport.setDocks(docks);

        List<Ship> ships = createListOfShips(seaport, semaphore, lock);

        List<Thread> threads = new ArrayList<>();

        for (Ship ship: ships) {
            Thread thread = new Thread(ship);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("В порту осталось: " + seaport.getCountOfContainers());


    }

    private static Seaport createSeaport() {
        Seaport seaport = new Seaport();
        seaport.setName(SEAPORT_NAME);
        seaport.setPortCapacity(SEAPORT_CAPACITY);
        seaport.setCountOfContainers(SEAPORT_CAPACITY);
        return seaport;
    }

    private static List<Dock> createListOfDocks() {
        List<Dock> docks = new ArrayList<>();

        for (int i = 0; i < COUNT_DOCKS; i++) {
            Dock dock = new Dock(true, i);
            docks.add(dock);
        }

        return docks;
    }

    private static List<Ship> createListOfShips(Seaport seaport, Semaphore semaphore, Lock lock) {
        List<Ship> ships = new ArrayList<>();

        for (int i = 0; i < COUNT_SHIPS; i++) {
            Ship ship = new Ship(SHIP_CARRYING, SHIP_NAME + i);
            ship.setCountOfContainers(ThreadLocalRandom.current().nextInt(SHIP_CARRYING));
            ship.setNeedLoading(ThreadLocalRandom.current().nextBoolean());
            ship.setSeaport(seaport);
            ship.setSemaphore(semaphore);
            ship.setLock(lock);
            ships.add(ship);
        }

        return ships;
    }





}
