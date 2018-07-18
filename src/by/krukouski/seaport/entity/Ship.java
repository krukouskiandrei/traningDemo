package by.krukouski.seaport.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Ship implements Runnable {

    private Integer carrying;
    private Integer countOfContainers;
    private Dock currentDock;
    private Seaport seaport;
    private Lock lock;
    private Semaphore semaphore;
    private boolean needLoading;
    private String name;

    public Ship(Integer carrying, String name) {
        this.carrying = carrying;
        this.name = name;
    }

    public Ship() {
    }

    public Ship(Integer carrying) {
        this.carrying = carrying;
    }

    public void setCurrentDock(Dock currentDock) {
        this.currentDock = currentDock;
    }

    public Integer getCountOfContainers() {
        return countOfContainers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setCountOfContainers(Integer countOfContainers) {
        this.countOfContainers = countOfContainers;
    }

    public void setSeaport(Seaport seaport) {
        this.seaport = seaport;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void setCarrying(Integer carrying) {
        this.carrying = carrying;
    }

    public void setNeedLoading(boolean needLoading) {
        this.needLoading = needLoading;
    }

    public boolean isNeedLoading() {
        return needLoading;
    }

    public Integer getCarrying() {
        return carrying;
    }

    public Dock getCurrentDock() {
        return currentDock;
    }

    public Seaport getSeaport() {
        return seaport;
    }

    public Lock getLock() {
        return lock;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Корабль " + name + " прибыл в порт " + seaport.getName() + " и ожидает захода в порт");

            semaphore.acquire();

            while (currentDock == null) {
                findFreeDock();
            }

            if (needLoading && countOfContainers > 0) {
                unloadShip();
                loadShip();
            } else if (needLoading) {
                loadShip();
            } else {
                unloadShip();
            }

            System.out.println("Крабль " + name + " вышел с причала №" + currentDock.getDockNumber() + " " + this);
            currentDock.unbookDock();
        } catch (InterruptedException e) {
            System.out.println("ERROR: something wasn't right with loading/unloading ship " + this + ", error message: " + e.getMessage());
        } finally {
            semaphore.release();
        }

    }

    private void loadShip(){
        lock.lock();
        Integer countOfContainersOnPort = seaport.getCountOfContainers();
        Integer loadCount;
        if (carrying - countOfContainers <= countOfContainersOnPort) {
            countOfContainers += countOfContainersOnPort;
            loadCount = countOfContainersOnPort;
            seaport.setCountOfContainers(0);
        } else {
            loadCount = carrying - countOfContainers;
            countOfContainers = carrying;
            seaport.subtractContainers(countOfContainers);
        }

        System.out.println("Корабль " + name + " загрузил " + loadCount +
                " контэйнеров, в порту " + seaport.getName() + " осталось " +
                seaport.getCountOfContainers() + " контэйнеров; грузаподъемность корабля " + carrying + " контэйнеров");
        lock.unlock();
    }

    private void unloadShip() {
        lock.lock();
        Integer freeSpace = seaport.getPortCapacity() - seaport.getCountOfContainers();
        Integer unloadCount;
        if(countOfContainers <= freeSpace) {
            seaport.addContainers(countOfContainers);
            unloadCount = countOfContainers;
            countOfContainers = 0;
        } else {
            countOfContainers -= freeSpace;
            seaport.addContainers(freeSpace);
            unloadCount = freeSpace;
        }

        System.out.println("Корабль " + name + " разгрузил " + unloadCount +
                " контэйнеров, в порту " + seaport.getName() + " осталось " +
                seaport.getCountOfContainers() + " контэйнеров; грузаподъемность корабля " + carrying + " контэйнеров");

        lock.unlock();
    }

    private void findFreeDock() {
        lock.lock();
        for (Dock dock: seaport.getDocks()) {
            if (dock.isFree()) {
                dock.bookDock();
                currentDock = dock;
                break;
            }
        }

        System.out.println("Корабль " + name + " зашел на причал №" + currentDock.getDockNumber());
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Ship{" +
                "carrying=" + carrying +
                ", countOfContainers=" + countOfContainers +
                ", needLoading=" + needLoading +
                '}';
    }
}
