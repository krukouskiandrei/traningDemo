package by.krukouski.io;

import java.io.*;

public class DemoWriter {

    public static void main(String[] args) {
        File file = new File("res.txt");
        double[] values = {1.10, 1.2, 1.401, 5.02, 6.014, 7, 8};
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);

            for (double version : values) {
                printWriter.printf("Java %.2g%n", version);
            }
        } catch (IOException e) {
            System.err.println("Error with stream opening: " + e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

}
