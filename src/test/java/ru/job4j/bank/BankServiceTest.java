package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUsers() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("3435", "Not Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.findByPassport("3434"), is(user1));
        assertThat(bank.findByPassport("3435"), is(user2));
    }

    @Test
    public void deleteUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertTrue(bank.deleteUser(user));
        assertFalse(bank.deleteUser(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        assertTrue(bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D));
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance(), is(0D));
    }

    @Test
    public void cantTransferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 50D));
        bank.addAccount(user.getPassport(), new Account("113", 150D));
        assertFalse(bank.transferMoney(user.getPassport(), "5546", user.getPassport(),
                "113", 150D));
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance(), is(50D));
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(150D));
    }

    @Test
    public void cantTransferMoneyNoSrcAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 50D));
        bank.addAccount(user.getPassport(), new Account("113", 150D));
        assertFalse(bank.transferMoney("344", "5546", user.getPassport(),
                "113", 150D));
    }

    @Test
    public void cantTransferMoneyNoDestAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 50D));
        bank.addAccount(user.getPassport(), new Account("113", 150D));
        assertFalse(bank.transferMoney(user.getPassport(), "5546", user.getPassport(),
                "1131", 150D));
    }
}