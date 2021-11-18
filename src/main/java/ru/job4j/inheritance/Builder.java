package ru.job4j.inheritance;

public class Builder extends Engineer {
    private boolean fatigue;

    public Builder(String name, String surname, String education, String birthday, int experience,
                   int previousJobs, boolean fatigue) {
        super(name, surname, education, birthday, experience, previousJobs);
        this.fatigue = fatigue;
    }

    public Builder(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public void build(Building newBuilding) {
        Brick brick = new Brick();
        newBuilding.addBrick(brick);
    }

}
