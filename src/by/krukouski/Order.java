package by.krukouski;

// класс доступен из других пакетов
public class Order {
    private int id; // переменная экземпляра класса
    static int bonus; // переменная класса
    public final int MIN_TAX = 8 + (int)(Math.random()*5); // константа экземпляра класса
    public final static int PURCHASE_TAX = 6; // константа класса

    // конструкторы

    // метод
    public double calculatePrice(double price, int counter) { /* параметры метода */
        double amount; // локальная переменная метода не получает значения по умолчанию
        // amount++; // ошибка компиляции, значение не задано
        amount = (price - bonus) * counter; // инициализация локальной переменной
        double tax = amount * PURCHASE_TAX /100;

        Account a = new Account(); /* инициализация полей значениями по умолчанию
            соответствующего типа, наличие нулевого id неприемлемо для логики класса */
        Account b = new Account(71L); /* инициализация одного  поля переданным в конструктор
            значением и другого поля по умолчанию */
        Account с = new Account(71L, 0.7); /* инициализация полей переданными в конструктор
              значениями */


        Post<String, Short> post1 = new Post<String, Short>();
        Post<StringBuilder, Long> post2 = new Post<>();
        Post<StringBuilder, Long> post3 = new Post<StringBuilder, Long>();


        TaxiStation ts = TaxiStation.valueOf(TaxiStation.class,"Volvo".toUpperCase());
        System.out.println(ts + " : ordinal -> " + ts.ordinal());
        ts.setFreeCabs(3);
        TaxiStation[ ] station = TaxiStation.values();
        for (TaxiStation element : station) {
            System.out.println(element);
        }






        int arRef[ ], ar; // объявление ссылки на массив и переменной
        float[ ] arRefFloat, arFloat; // два массива!
        // объявление с инициализацией нулевыми значениями по умолчанию
        int arDyn[ ] = new int[10]; // 10 нулей
        String str[ ] = new String[7]; // 7 null-ов
        /* объявление с инициализацией */
        int arInt[ ] = { 5, 7, 9, -5, 6, -2 }; // 6 элементов
        arInt = new int[ ] { 5, 7, 9, -5, 6, -2 }; // идентично предыдущему
        byte arByte[ ] = {1, 3, 5 };// 3 элемента
        /* объявление с помощью ссылки на Object */
        Object arObj = new float[5]; // массив является объектом
        // допустимые присваивания ссылок
        arRef = arDyn;
        arDyn = arInt;
        arRefFloat = (float[ ])arObj;
        arObj = arByte; // источник ошибки для следующей строки
        arRefFloat = (float[ ])arObj; // ошибка выполнения
        // недопустимые присваивания ссылок (нековариантность)
        // arInt = arByte;
        // arInt = (int[ ])arByte;


        return amount + tax; // возвращаемое значение

    }
}
