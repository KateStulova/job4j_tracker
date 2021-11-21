package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java Performance", 450);
        Book book2 = new Book("Clean code", 640);
        Book book3 = new Book("Code Complete", 760);
        Book book4 = new Book("The Lord of the Rings", 900);
        Book[] books = new Book[]{book1, book2, book3, book4};
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getTitle())) {
                System.out.println(book.getTitle());
            }
        }
    }
}
