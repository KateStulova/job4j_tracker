package ru.job4j.tracker.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println(active + ", " + status + ", " + message + ".");
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 200, "OK");
        Error error3 = new Error(false, 500, "Internal Server Error");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
