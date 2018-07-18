package by.krukouski;

public class Account {

    private long id;
    private double amount;

    // конструктор без параметров
    public Account() { // наличие этого конструктора некорректно по смыслу класса
        super(); /* если класс будет объявлен вообще без конструктора, то компилятор предоставит его именно в таком виде */
    }
    // конструктор с параметром
    public Account(long id) {
        super(); /* вызов конструктора суперкласса явным образом необязателен, компилятор вставит его автоматически */
        this.id = id;
    }
    // конструктор с параметрами
    public Account(long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public double getAmount () {
        return amount;
    }
    public void setAmount (double amount) {
        this.amount = amount;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        // проверка на корректность
        this.id = id;
    }
    public void addAmount (double amount) {
        /* данный метод в общем случае можно объявлять в другом классе */
        this.amount += amount;
    }

}
