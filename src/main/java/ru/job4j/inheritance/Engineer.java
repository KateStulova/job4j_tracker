package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int experience;
    private int previousJobs;

    public Engineer(String name, String surname, String education, String birthday,
                    int experience, int previousJobs) {
        super(name, surname, education, birthday);
        this.experience = experience;
        this.previousJobs = previousJobs;
}

    public boolean findJob() {
        return super.getEducation() != null && experience > 15 && previousJobs <= 4;
    }
}
