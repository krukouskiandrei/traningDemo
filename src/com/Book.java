package com;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublising;
    private int numOfPages;
    private double cost;
    private String typeOfBinding;

    public Book() {

    }

    public Book(int id, String title, String author, String publisher, int yearOfPublising, int numOfPages, double cost, String typeOfBinding) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.yearOfPublising = yearOfPublising;
        this.typeOfBinding = typeOfBinding;
    }

    public Book(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublising() {
        return yearOfPublising;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getTypeOfBinding() {
        return typeOfBinding;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublising(int yearOfPublising) {
        this.yearOfPublising = yearOfPublising;
    }

    public void setTypeOfBinding(String typeOfBinding) {
        this.typeOfBinding = typeOfBinding;
    }

    @Override
    public String toString() {
        return "Книга " + title + "(id=" + id + ");\n автор: " + author + ";\n издательство: " + publisher + ";\n год выпуска: " + yearOfPublising + ";\n количество страниц: " + numOfPages + ";\n цена:" + cost + ";\n тип переплета: " + typeOfBinding;
    }
}
