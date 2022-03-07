package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает сущность пользователя с помощью паспорта и имени пользователя
 * @author Kate Stulova
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя
     */
    private String passport;
    /**
     * Имя пользователя
     */
    private String username;

    /**
     * Конструктор объекта User
     *
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для поля passport
     *
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для поля passport
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для поля username
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для поля username
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
