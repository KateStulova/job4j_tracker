package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                rsl = user;
            }
        }
        if (rsl == null) {
            throw new UserInvalidException("Пользователь не найден");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = user.isValid() && user.getUsername().length() > 3;
        if (!rsl) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Kate Stulova", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException eun) {
            eun.printStackTrace();
        }
    }
}
