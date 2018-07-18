package storage;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

 public class Storage implements Iterable<Container>, Runnable {
    private String name;
    private BlockingQueue<Container> goods;
    public static final int capacity=40;
    private int quntity;

    public Storage() {

    }

    public Storage(String name, BlockingQueue<Container> goods, int quntity) {
        this.name = name;
        this.goods = goods;
        if (quntity>capacity) {
            this.quntity = capacity;
        }
    }

    public Storage createStorage(String name, BlockingQueue<Container> goods, int quntity){
        Storage storage = new Storage(name, goods, quntity);
        storage.goods.addAll(goods);// this.goods = goods;
        return storage;
    }

    public boolean dive(Container container){
        return goods.offer(container);
    }

    public Container unload (){
        return goods.poll();
    }


    @Override
    public Iterator<Container> iterator() {
        return goods.iterator();
    }

     @Override
     public void run() {

     }
 }
