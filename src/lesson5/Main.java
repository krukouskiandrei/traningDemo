package lesson5;

import java.util.Arrays;
import java.util.Scanner;

/*Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти
 д анные на консоль.
// В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов. Car: id, Марка, Модель,
Год выпуска, Цвет, Цена, Регистрационный номер.
// Создать массив объектов. Вывести:
// a) список автомобилей заданной марки;
// b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
// c) список автомобилей заданного года выпуска, цена которых больше указанной.*/
public class Main {



    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4, 5};
        String[] mark = {"Mercedes", "BMW", "Citroen", "Peugeot", "Mazda"};
        String[] model = {"W203", "X5", "Xantia", "203", "323"};
        int[] year = {2005, 2017, 1997, 1985, 2010};
        String[] color = {"Yelow", "Black", "Green", "White", "Red"};
        int[] cost = {6666, 203887, 453, 9514, 15000};
        String[] registrationSign = {"1234-2", "AB 3452", "Rudolph", "5432-AB5", "LikeaBoSS"};

        Car[] cars = new Car[id.length];
        for (int i = 0; i < id.length; i++) {
            Car car = new Car(id[i],
                    mark[i], model[i], year[i], color[i],
                    cost[i], registrationSign[i]);
                    cars[i] = car;
            }
 abc(cars);
    }

    public static void abc (Car [] cars){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите 1, для получния списка автомобилей заданной марки,"+"\n"+
                            "Введите 2 для получения списка автомобилей заданной модели, " +
                              "которые эксплуатируются больше n лет"+"\n"+ "Введите 3 для получения списка" +
                            "  автомобилей заданного года выпуска, цена которых больше указанной");
       int enter = 0;
        enter =  scan.nextInt();
        switch (enter){
            case 1: {
                String inputMark;
                System.out.println("Введите марку авто");
                inputMark=scan.next();
                for (int i=0;i <cars.length; i++){
                    if (cars[i].getMark().equals(inputMark)){
                        System.out.println(cars[i].toString());
                    }
                }
            }
            case 2: {
                String inputModel;
                int inputOld;
                System.out.println("Ведите модель авто");
                inputModel=scan.next();

              OUT:  for (int i=0;i <cars.length; i++){
                    if (cars[i].getModel().equals(inputModel)){

                        for (int x=0 ;x <cars.length; x++){

                            System.out.println("Эксплуатируется больше скольки лет? ");
                            inputOld=scan.nextInt();
                                    if (cars[x].getYear()<2018-inputOld){

                                    System.out.println(cars[x].toString());

                                }
                                if (cars[x].getYear()==2018-inputOld){

                                System.out.println("Точное совпадение "+cars[x].toString());
                                break OUT;
                                }

                                else {

                                    System.out.println("Нет таких авто");

                                }
                         }
                            }else{System.out.println("Нет таких марок");

                            }

                }

            }
        }
    }
}