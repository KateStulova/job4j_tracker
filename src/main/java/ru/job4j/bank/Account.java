package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает сущность банковского счета с помощью реквизита и баланса
 * @author Kate Stulova
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета
     */
    private String requisite;
    /**
     * Баланс банковского счета
     */
    private double balance;

    /**
     * Конструктор объекта Account
     *
     * @param requisite реквизиты банковского счета
     * @param balance баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер для поля requisite
     *
     * @return реквизиты банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер для поля requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер для поля balance
     *
     * @return баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер для поля balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
