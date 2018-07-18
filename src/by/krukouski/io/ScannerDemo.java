package by.krukouski.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        String fileName = "scan.txt";
        Scanner scanner = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                if(scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt() + " : int");
                } else if(scanner.hasNextBoolean()) {
                    System.out.println(scanner.nextBoolean() + " : boolean");
                } else if (scanner.hasNextDouble()) {
                    System.out.println(scanner.nextDouble() + " : double");
                } else {
                    System.out.println(scanner.next() + " : String");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}
