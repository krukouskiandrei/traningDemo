package by.krukouski;

public class Runner {

    public static void main(String[] args) {
        My1 object = new My1();
        prepare(object);
        object.setName("name");
        System.out.println(object.getName() + object.getValue());

    }

    private static void prepare(My object) {
        object.setValue(2);
    }

}
