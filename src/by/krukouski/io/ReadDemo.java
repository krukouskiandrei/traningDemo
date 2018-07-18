package by.krukouski.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadDemo {

    public static void main(String[] args) {
        String fileName = "src\\file.txt";
        File file = new File(fileName);
        int b, count = 0;
        //FileReader reader = null;
        FileInputStream reader = null;
        try {
            //reader = new FileReader(file);
            reader = new FileInputStream(file);
            /*while ((b = reader.read()) != -1) {*/
            b = reader.read();
            while (b != -1) {
                System.out.print((char) b);
                b = reader.read();
                count++;
            }
            System.out.println("\n" + count);
        } catch (IOException e) {
            System.err.println("Error in file: " + e );
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error with closing: " + e);
            }
        }
    }

}
