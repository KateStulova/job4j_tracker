package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private int projects;

    public Programmer(String name, String surname, String education, String birthday,
                      int experience, int previousJobs, int projects) {
        super(name, surname, education, birthday, experience, previousJobs);
        this.projects = projects;
    }

    public void addProject() {
        this.projects += 1;
    }
}
