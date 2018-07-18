package by.krukouski.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("DemoReader.java");

        if(file.exists()) {
            System.out.println(file.getName() + " exists");

            if (file.isFile()) {
                System.out.println("File path:\t" + file.getPath());
                System.out.println("File absolute path:\t" + file.getAbsolutePath());
                System.out.println("File size:\t" + file.length());
                System.out.println("Last modification:\t" + new Date(file.lastModified()));
                System.out.println("File has read mode:\t" + file.canRead());
                System.out.println("File has write mode:\t" + file.canWrite());
                System.out.println("File is deleted:\t" + file.delete());
            }
        } else {
            System.out.println("file " + file.getName() + " doesn't exist");
            try {
                if(file.createNewFile()) {
                    System.out.println("file " + file.getName() + " created");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File dir = new File("src" + File.separator + "by" + File.separator + "krukouski");

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Directory " + dir.getName() + " exists");

            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                Date date = new Date(files[i].lastModified());
                System.out.println("\n" + files[i].getPath() + "\t| " + files[i].length() + "\t| " + date);
            }

            File root = File.listRoots()[1];
            System.out.printf("\n%s %,d from %,d is free.", root.getPath(), root.getUsableSpace(), root.getTotalSpace());
        }
    }

}
