package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private boolean talent;

    public Surgeon(String name, String surname, String education, String birthday, int experience,
                   boolean patientSatisfaction, boolean talent) {
        super(name, surname, education, birthday, experience, patientSatisfaction);
        this.talent = talent;
    }

    public int sewUp(Patient patient) {
        Suture sut = new Suture();
        return patient.addSuture(sut);
    }
}
