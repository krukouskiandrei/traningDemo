package THREADLesson12;

public class Ship implements  Runnable {
    private int value;
    private int containers;
    private String name;

    @Override
    public String toString() {
        return "Корабль " + name +" "+
                "Вместительностью = " + value +
                " и Числом контейнеров=" + containers ;
    }

    public Ship() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getContainers() {
        return containers;
    }

    public void setContainers(int containers) {
        this.containers = containers;
    }

    public Ship(int value, int containers, String name) {
        this.value = value;
        this.containers = containers;
        this.name = name;
    }

    @Override
    public void run() {

    }
}
