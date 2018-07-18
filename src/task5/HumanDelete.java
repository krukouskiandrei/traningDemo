package task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class HumanDelete {

    public static BufferedReader reader;

    public static void main(String[] args) {

        openReader();

        int n = printNumberHuman();
        ArrayList<Human> arrayList = new ArrayList<>();
        LinkedList<Human> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(createHuman());
        }
        linkedList.addAll(arrayList);


        while (arrayList.size() != 1) {
            for (int i = arrayList.size(); i > 0; i--) {
                arrayList.remove(--i);
            }
        }
//
//        while (linkedList.size() != 1) {
//            for (int i = linkedList.size(); i > 0; i--) {
//                linkedList.remove(--i);
//            }
//        }
        System.out.println(arrayList);
        System.out.println();
        System.out.println(linkedList);

        closeReader();
    }


    public static Human createHuman() {
        String[] arr = printMargins();
        while (arr.length != 3) {
            System.out.println("Данные введены неверно, введите корректные данные!");
            arr = printMargins();
        }
        try {
            int id = Integer.parseInt(arr[0]);
            int age = Integer.parseInt(arr[2]);
        } catch (NumberFormatException exc) {
            System.out.println("Введите корректные данные!");
            arr = printMargins();
        }
        return new Human(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
    }

    public static int printNumberHuman() {
        int number = 0;
        System.out.println("Введите количество человек:");
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException exc) {
            System.out.println("Ошибка ввода с клавиатуры.");
        }
        return number;
    }

    public static String[] printMargins() {
        String string = null;
        String[] arr = null;
        System.out.println("Введите данные по человеку в формате: \"id, имя, возраст\": ");
        try {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (string != null) {
            string = string.trim();
            arr = string.split("(\\W+$)|(\\s+\\W+\\s+)|(\\W+)|(\\W+\\s+)");
        }
        return arr;
    }

    private static void openReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void closeReader() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
