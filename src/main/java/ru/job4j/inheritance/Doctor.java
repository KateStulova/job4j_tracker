package ru.job4j.inheritance;

public class Doctor extends Profession {
    private int experience;
    private boolean patientSatisfaction;

    public Doctor(String name, String surname, String education, String birthday, int experience,
                  boolean patientSatisfaction) {
        super(name, surname, education, birthday);
        this.experience = experience;
        this.patientSatisfaction = patientSatisfaction;
    }

    public Doctor(int experience, boolean patientSatisfaction) {
        this.experience = experience;
        this.patientSatisfaction = patientSatisfaction;
    }

    public Doctor() {
    }

    public void cure(Patient patient) {
        while (!patient.tryTocure()) {
            System.out.println("Лечим дальше, пациент все еще болен.");
        }
    }
}
