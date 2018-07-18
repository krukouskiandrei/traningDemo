package lesson5;

import java.util.Objects;

public class Car {
    private int id;
    private String mark;
    private String model;
    private  int year;
    private String color;
    private  int cost;
    private String registrationSign;


    public Car () {}


    public Car (int id, String mark, String model, int year, String color, int cost, String registrationSign) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.color = color;
        this.cost = cost;
        this.registrationSign = registrationSign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                year == car.year &&
                cost == car.cost &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(registrationSign, car.registrationSign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, year, color, cost, registrationSign);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                ", registrationSign='" + registrationSign + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRegistrationSign() {
        return registrationSign;
    }

    public void setRegistrationSign(String registrationSign) {
        this.registrationSign = registrationSign;
    }
}

