package by.krukouski.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        /*BoxPrinter<Integer> value1 = new BoxPrinter<Integer>(new Integer(10));
        System.out.println(value1);
        Integer intValue1 = value1.getValue();
        BoxPrinter<String> value2 = new BoxPrinter<String>("Hello world");
        System.out.println(value2);
        BoxPrinter<String> value23 = new BoxPrinter<>(new String("10"));
        // Здесь повторяется ошибка предыдущего фрагмента кода
        //Integer intValue2 = value2.getValue();



        Pair<Integer, String> pair = new Pair<Integer, String>(6,
                " Apr");
        System.out.println(pair.getFirst() + pair.getSecond());*/




        List list = new LinkedList();
        list.add("First");
        list.add("Second");
        list.add("Secosdsdsdnd");
        //list.add(10);//list.add(10)
        List<String> list2 = list;

        for(Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();)
            System.out.println(itemItr.next());


        List<String> list1 = new LinkedList<String>();
        list1.add("First");
        list1.add("Second"); // list.add(10)
        List list3 = list1;
        for(Iterator<String> itemItr = list3.iterator(); itemItr.hasNext();)
            System.out.println(itemItr.next());





        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        System.out.println("Список до обработки дженерик-методом: " + intList);
        Utilities.fill(intList, 0);
        System.out.println("Список после обработки дженерик-методом: "
                + intList);


        /*List<Number> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(new Integer(10));
        integerArrayList.add(new Float(10.0f));*/


        List<Integer> list4 = new ArrayList<>();
        list4.add(10);
        list4.add(100);
        printList(list4);
        List<String> strList = new ArrayList<>();
        strList.add("10");
        strList.add("100");
        printList(strList);

    }

    static void printList(List<?> list) {
        for (Object l : list)
            System.out.println("{" + l + "}");
    }

}

class BoxPrinter<T> {
    private T val;

    public BoxPrinter(T arg) {
        val = arg;
    }

    public String toString() {
        return "{" + val + "}";
    }

    public T getValue() {
        return val;
    }
}

class Pair<T1, T2> {
    T1 object1;
    T2 object2;

    Pair(T1 one, T2 two) {
        object1 = one;
        object2 = two;
    }

    public T1 getFirst() {
        return object1;
    }

    public T2 getSecond() {
        return object2;
    }
}

class PairOfT<T> {
    T object1;
    T object2;

    PairOfT(T one, T two) {
        object1 = one;
        object2 = two;
    }

    public T getFirst() {
        return object1;
    }

    public T getSecond() {
        return object2;
    }
}

class Utilities {
    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
    }
}