package by.krukouski.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoReader {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("res.txt"));
            String tmp = "";
            while ((tmp = bufferedReader.readLine()) != null) {
                String[] strings =  tmp.split("\\s");
                for (String res : strings) {
                    System.out.println(res);
                }
            }
        } catch (IOException e) {
            System.err.println("Error with stream opening: " + e);
        } finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
