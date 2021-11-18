package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int grade;

    public Dentist(String name, String surname, String education, String birthday, int experience,
                   boolean patientSatisfaction, int grade) {
        super(name, surname, education, birthday, experience, patientSatisfaction);
        this.grade = grade;
    }

    public Dentist(int grade) {
        this.grade = grade;
    }

    public boolean removeTooth() {
        return super.getEducation() != null && grade > 30;
    }

}
