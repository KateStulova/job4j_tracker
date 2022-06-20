package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Осуществляет поиск пользователя по паспорту в банковской базе клиентов
     *
     * @param passport паспорт пользователя
     * @return либо объект Optional<User>, либо пустой Optional
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    /**
     * Осуществляет поиск счета по паспорту и реквизитам в банковской базе клиентов
     *
     * @param passport паспорт пользователя
     * @param requisite реквизиты банковского счета
     * @return либо объект Optional<Account>, либо пустой Optional
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(acc -> requisite.equals(acc.getRequisite()))
                .findFirst());
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
