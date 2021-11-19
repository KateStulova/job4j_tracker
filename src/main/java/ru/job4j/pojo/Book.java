package ru.job4j.pojo;

public class Book {
    private String title;
    private int sheetsNumber;

    public Book(String title, int sheetsNumber) {
        this.title = title;
        this.sheetsNumber = sheetsNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSheetsNumber() {
        return sheetsNumber;
    }

    public void setSheetsNumber(int sheetsNumber) {
        this.sheetsNumber = sheetsNumber;
    }
}
