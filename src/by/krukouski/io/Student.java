package by.krukouski.io;

import java.io.Serializable;

public class Student implements Serializable {
    protected static String faculty;
    private int id;
    private String name;
    private transient String password;


    public Student(String nameOfFaculty, String name, int id, String password) {
        faculty = nameOfFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public static String getFaculty() {
        return faculty;
    }

    public static void setFaculty(String faculty) {
        Student.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "\nfaculty " + faculty + "\nname " + name + "\nID " + id + "\npassword " + password;
    }
}