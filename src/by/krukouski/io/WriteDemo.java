package by.krukouski.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDemo {

    public static void main(String[] args) {
        String pArray[] = { "2018", "Java SE 8"};
        File fileByte = new File("byte.txt");
        File fileSymbol = new File("symbol.txt");
        FileOutputStream fileOutputStream = null;
        FileWriter fileWriter = null;

        try {
            fileOutputStream = new FileOutputStream(fileByte);
            fileWriter = new FileWriter(fileSymbol);
            for (String a: pArray) {
                fileOutputStream.write(a.getBytes());
                fileWriter.write(a);
            }
        } catch (IOException e) {
            System.err.println("Error with output: " + e);
        } finally {
            try {
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error with closing outputStream: " + e);
            }

            try {
                if(fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.err.println("Error with closing fileWriter: " + e);
            }
        }
    }

}
