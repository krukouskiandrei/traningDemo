package by.krukouski.collections;

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {
        /*ArrayList<String> list = new ArrayList<>();
        //ArrayList<int> list1 = new ArrayList<int>(); //ошибка компиляции
        for (int i = 0; i < 10; i++) {
            list.add("Java");
            list.add("Java 8");
        }
        String result = list.get(0);
        //list.add(new StringBuilder("C#")); // ошибка компиляции
        System.out.println();*/




        /*ArrayList raw = new ArrayList(); *//*{
            {
                add(new Order(231, 12.f));
                add(new Item(23232, 120.f, "Xerox"));
                add(new Order(343, 23.f));
            }
        };*//*

        raw.add(new Order(231, 12.f));
        raw.add(new Item(23232, 120.f, "Xerox"));
        raw.add(new Order(343, 23.f));

        Order or1 = (Order) raw.get(0);
        Item or2 = (Item) raw.get(1);
        Order or3 = (Order) raw.get(2);

        for (Object obj : raw) {
            System.out.println("raw " + obj);
        }

        ArrayList<Order> orders = new ArrayList<Order>() {
            {
                add(new Order(231, 12.f));
                //add(new Item(23232, 120.f, "Xerox"));
                add(new Order(343, 23.f));
            }
        };

        //orders.add(new Item(23232, 120.f, "Xerox"));
        //float res = orders.get(0).getAmount();

        for (Order obj : orders) {
            System.out.println("raw " + obj);
        }

*/        /*ArrayList<Order> orders = new ArrayList<Order>() {
            {
                add(new Order(231, 12.f));
                add(new Order(389, 2.9f));
                add(new Order(217, 1.7f));
            }
        };
        FindOrder fo = new FindOrder();
        List<Order> res = fo.findBiggerAmountOrder(10f, orders);
        System.out.println(res);*/
        LinkedList<Order> orders = new LinkedList<Order>() {
            {
                add(new Order(231, 12.f));
                add(new Order(389, 2.9f));
                add(new Order(217, 1.7f));
            }
        };
        Queue<Order> queueA = orders;
        queueA.offer(new Order(233, 23.2f));
        System.out.println(orders);
        orderProcessing(queueA);
        if (queueA.isEmpty()) {
            System.out.println("Queue of Orders is empty");
        }

    }

    public static void orderProcessing(Queue<Order> queue) {
        Order obj = null;
        while ((obj = queue.poll()) != null) {
            System.out.println("Order #" + obj.getOrderId() + " is processing");
        }
    }

}

class FindOrder {

    public List<Order> findBiggerAmountOrder(float bigAmount, List<Order> orders) {
        ArrayList<Order> bigPrices = new ArrayList();
        Iterator<Order> it = orders.iterator();

        while (it.hasNext()) {
            Order current = it.next();
            if(current.getAmount() >= bigAmount) {
                bigPrices.add(current);
            }
        }

        return bigPrices;
    }
}