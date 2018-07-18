package storage;

public class Container {
    private int id;
    private int weight;

    public Container() {

    }

    public Container(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
