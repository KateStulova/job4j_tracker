package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java Performance", 450);
        Book book2 = new Book("Clean code", 640);
        Book book3 = new Book("Code Complete", 760);
        Book book4 = new Book("The Lord of the Rings", 900);
        Book[] books = new Book[]{book1, book2, book3, book4};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle());
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals("Clean code")) {
                System.out.println(books[i].getTitle());
            }
        }
    }
}
