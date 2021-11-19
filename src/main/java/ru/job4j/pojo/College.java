package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student ivanov = new Student();
        ivanov.setFullName("Иванов Иван Иванович");
        ivanov.setGroup(1);
        ivanov.setReceiptDate("11.12.2000");
        System.out.println(ivanov.getFullName() + " учится в группе № " + ivanov.getGroup()
                + ", поступил " + ivanov.getReceiptDate() + ".");
    }
}
