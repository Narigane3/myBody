package org.example.model;

public class Training {

    private String name;
    private String duration;
    private String data;
    private String postExerciseRecovery;
    private String charge;

    public Training(String name, String duration, String data, String postExerciseRecovery, String charge) {
        this.name = name;
        this.duration = duration;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
