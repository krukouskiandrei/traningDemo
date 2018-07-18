package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        String[] names = {"Война и Мир", "Филосовия Java", "Преступление и наказание", "Совершенный код", "Горе от ума"};
        String[] authors = {"Л.Н.Толстой", "Б.Эккель", "Ф.М.Достоевский", "С.Макконнелл", "А.С.Грибоедов"};
        String[] publishers = {"Москва", "Harvard", "Асвета", "Oxford", "Эксмо"};
        int[] numPages = {608, 345, 289, 313, 69};
        int[] yearsPublish = {1964, 2003, 1995, 2010, 1708};
        String[] typeBinding = {"твердый", "мягкий"};
        int[] costs = {288, 15, 3000, 139, 15};

        List<Book> bookList = new ArrayList<>();
        Book[] books = new Book[5];
        for (int bookCreateIndex = 0; bookCreateIndex < names.length; bookCreateIndex++) {
            if (bookCreateIndex / 2 == 0) {
                Book book = new Book(bookCreateIndex, names[bookCreateIndex], authors[bookCreateIndex],
                        publishers[bookCreateIndex], yearsPublish[bookCreateIndex],
                        numPages[bookCreateIndex], costs[bookCreateIndex], typeBinding[1]);
                books[bookCreateIndex] = book;
                bookList.add(book);
            } else {
                Book book = new Book(bookCreateIndex, names[bookCreateIndex], authors[bookCreateIndex],
                        publishers[bookCreateIndex], yearsPublish[bookCreateIndex],
                        numPages[bookCreateIndex], costs[bookCreateIndex], typeBinding[0]);
                books[bookCreateIndex] = book;
                bookList.add(book);
            }
        }

        chooseAction(bookList, books);
    }

    public static void arrayOperations() {
        System.out.println("Task10:");
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        double[] array3 = new double[10];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 9);
            System.out.print(array1[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < array2.length; i++) {

            array2[i] = (int) (Math.random() * 9);
            System.out.print(array2[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (array1[i] / array2[i]);
            System.out.print(array3[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < array3.length; i++) {
            if(array3[i] % 1 == 0){
                System.out.print(array3[i] + " ");
            }


        }
        System.out.println("");
    }

    private static void chooseAction(List<Book> bookList, Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие: 1-вывести список книг заданного автора, 2-вывести список книг, выпущенных заданным издательством, 3-вывести список книг, выпущенных после заданного года, 4-добавить книгу, 5-выход");
        int choose = 0;
        choose = scanner.nextInt();
        switch (choose) {
            case 1: {
                String inputAuthor;
                System.out.println("Введите автора");
                inputAuthor = scanner.next();

                for(int i = 0; i < books.length; i++) {
                    if(books[i].getAuthor().equals(inputAuthor)) {
                            System.out.println(books[i].toString());
                    }

                }

                for (Book aBook : bookList) {
                    if (aBook.getAuthor().equals(inputAuthor))
                        System.out.println(aBook.toString());
                }
                chooseAction(bookList, books);
            }
            case 2: {
                String inputPublisher;
                System.out.println("Введите издательство");
                inputPublisher = scanner.next();
                for (Book aBook : bookList) {
                    if (aBook.getPublisher().equals(inputPublisher))
                        System.out.println(aBook.toString());
                }
                chooseAction(bookList, books);
            }
            case 3: {
                int inputYear = 0;
                System.out.println("Введите год выпуска");
                inputYear = scanner.nextInt();
                for (Book aBook : bookList) {
                    if (aBook.getYearOfPublising() > inputYear)
                        System.out.println(aBook.toString());
                }
                chooseAction(bookList, books);
            }
            case 4: {
                Book book = new Book();
                System.out.println("Введите индекс");
                int index = scanner.nextInt();
                book.setId(index);
                System.out.println("Введите название");
                String title = scanner.next();
                book.setTitle(title);
                System.out.println("Введите автора");
                String author = scanner.next();
                book.setAuthor(author);
                System.out.println("Введите издательство");
                String publisher = scanner.next();
                book.setPublisher(publisher);
                System.out.println("Введите год издания");
                int yearOfPublising = scanner.nextInt();
                book.setYearOfPublising(yearOfPublising);
                System.out.println("Введите количество страниц");
                int numOfPages = scanner.nextInt();
                book.setNumOfPages(numOfPages);
                System.out.println("Введите цену");
                int cost = scanner.nextInt();
                book.setCost(cost);
                System.out.println("Введите тип переплета");
                String typeOfBinding = scanner.next();
                book.setTypeOfBinding(typeOfBinding);

                books = updateBooks(books, book);
                bookList.add(book);
                chooseAction(bookList, books);
            }
            case 5: break;
        }
    }

    private static Book[] updateBooks(Book[] books, Book book) {
        Book[] newBooks = new Book[books.length + 1];
        int index = 0;
        for (Book currentBook : books) {
            newBooks[index] = currentBook;
            index++;
        }

        newBooks[index] = book;

        return newBooks;
    }
}
