package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUsers() {
        Optional<User> user1 = Optional.of(new User("3434", "Petr Arsentev"));
        Optional<User> user2 = Optional.of(new User("3435", "Not Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user1.get());
        bank.addUser(user2.get());
        assertThat(bank.findByPassport("3434"), is(user1));
        assertThat(bank.findByPassport("3435"), is(user2));
    }

    @Test
    public void deleteUser() {
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        assertTrue(bank.deleteUser(user.get()));
        assertFalse(bank.deleteUser(user.get()));
    }

    @Test
    public void whenEnterInvalidPassport() {
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        bank.addAccount(user.get().getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        bank.addAccount(user.get().getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        bank.addAccount(user.get().getPassport(), new Account("5546", 150D));
        bank.addAccount(user.get().getPassport(), new Account("113", 50D));
        assertTrue(bank.transferMoney(user.get().getPassport(), "5546",
                user.get().getPassport(), "113", 150D));
        assertThat(bank.findByRequisite(user.get().getPassport(), "113")
                .get().getBalance(), is(200D));
        assertThat(bank.findByRequisite(user.get().getPassport(), "5546")
                .get().getBalance(), is(0D));
    }

    @Test
    public void cantTransferMoney() {
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        bank.addAccount(user.get().getPassport(), new Account("5546", 50D));
        bank.addAccount(user.get().getPassport(), new Account("113", 150D));
        assertFalse(bank.transferMoney(user.get().getPassport(), "5546", user.get().getPassport(),
                "113", 150D));
        assertThat(bank.findByRequisite(user.get().getPassport(), "5546")
                .get().getBalance(), is(50D));
        assertThat(bank.findByRequisite(user.get().getPassport(), "113")
                .get().getBalance(), is(150D));
    }

    @Test
    public void cantTransferMoneyNoSrcAccount() {
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        bank.addAccount(user.get().getPassport(), new Account("5546", 50D));
        bank.addAccount(user.get().getPassport(), new Account("113", 150D));
        assertFalse(bank.transferMoney("344", "5546", user.get().getPassport(),
                "113", 150D));
    }

    @Test
    public void cantTransferMoneyNoDestAccount() {
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        bank.addAccount(user.get().getPassport(), new Account("5546", 50D));
        bank.addAccount(user.get().getPassport(), new Account("113", 150D));
        assertFalse(bank.transferMoney(user.get().getPassport(), "5546", user.get().getPassport(),
                "1131", 150D));
    }
}