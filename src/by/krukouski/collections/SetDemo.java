package by.krukouski.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        boolean b;

        for(int i = 0; i < 6; i++) {
            list.add((int) (Math.random() * 10) + "Y ");
        }

        System.out.println("list: " + list);

        TreeSet<String> set = new TreeSet<>(list);
        System.out.println("set: " + set);

        System.out.println(set.comparator());

        System.out.println(set.last() + " " + set.first());

        HashSet<String> hashSet = new HashSet<>(set);
        for (String str : hashSet) {
            System.out.println(str + " " + str.hashCode());
        }
    }

}
