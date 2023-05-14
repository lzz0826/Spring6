package com.tony.di;

public class Book {

    private String bname;

    private String author;

    private String other;

    public String getBname() {
        return bname;
    }

    public Book() {
        System.out.println("無參構造執行了...");
    }

    public Book(String bname, String author) {
        System.out.println("有參構造執行了...");
        this.bname = bname;
        this.author = author;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public static void main(String[] args) {


        //set 方法
        Book book = new Book();

        book.setBname("java");
        book.setAuthor("tony");



        //構造器注入
        Book book2 = new Book("c++","tony");


    }
}
