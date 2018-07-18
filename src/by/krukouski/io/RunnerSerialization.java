package by.krukouski.io;

import java.io.InvalidObjectException;

public class RunnerSerialization {

    public static void main(String[] args) {
        //Student ob = new Student("MMF", "Goncharenko", 1, "G017s9");
        //System.out.println(ob);
        String file = "demo.data";
        Serializator sz = new Serializator();
        //boolean b = sz.serialization(ob, file);
        Student.faculty = "GEO";
        Student res = null;
        try {
            res = sz.deserialization(file);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
