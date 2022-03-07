package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы
 * @author Kate Stulova
 * @version 1.0
 */
public class BankService {
    /**
     * Мапа с пользователями и списком счетов по каждому из них,
     * аналог банковской базы клиентов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пару - новый пользователь и список счетов в users,
     * если такой пары еще не существует
     *
     * @param user сущность пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаляет из users пару - пользователь и список счетов
     *
     * @param user сущность пользователя
     * @return либо true, либо false
     */
    public boolean deleteUser(User user) {
        return users.remove(user) != null;
    }

    /**
     * Добавляет новый счет в список счетов конкретного пользователя в users
     *
     * @param passport паспорт пользователя
     * @param account сущность банковского счета
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Осуществляет поиск пользователя по паспорту в банковской базе клиентов
     *
     * @param passport паспорт пользователя
     * @return либо объект User, либо null
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Осуществляет поиск счета по паспорту и реквизитам в банковской базе клиентов
     *
     * @param passport паспорт пользователя
     * @param requisite реквизиты банковского счета
     * @return либо объект Account, либо null
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account acc : userAccounts) {
                if (requisite.equals(acc.getRequisite())) {
                    rsl = acc;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Осуществляет перевод денежных средств со счета на счет
     *
     * @param srcPassport паспорт пользователя-отправителя
     * @param srcRequisite реквизиты банковского счета пользователя-отправителя
     * @param destPassport паспорт пользователя-получателя
     * @param destRequisite реквизиты банковского счета пользователя-получателя
     * @param amount денежная сумма для перевода
     * @return либо true, либо false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
