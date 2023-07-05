package org.example.model;

public class Training {

    private String name;
    private String duration;
    private String date;
    private String postExerciseRecovery;
    private String charge;

    public Training(String name, String duration, String date, String postExerciseRecovery, String charge) {
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.postExerciseRecovery = postExerciseRecovery;
        this.charge = charge;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPostExerciseRecovery() {
        return postExerciseRecovery;
    }

    public void setPostExerciseRecovery(String postExerciseRecovery) {
        this.postExerciseRecovery = postExerciseRecovery;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
