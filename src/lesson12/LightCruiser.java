package lesson12;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LightCruiser {

    private int health = 100;
    private boolean isDamaged;
    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void repair() {
        lock.readLock().lock();
        if(isDamaged) {
            lock.writeLock().lock();
            health += 1;
            isDamaged = false;
            lock.writeLock().unlock();
        }
        lock.readLock().unlock();
    }

    public void shoot() {
        lock.writeLock().lock();
        health -= 10;
        isDamaged = true;
        lock.writeLock().unlock();
    }

    public int getHealth() {
        lock.readLock().lock();
        int result = health;
        lock.readLock().unlock();
        return result;
    }

}
