package org.example.repository;

import org.example.model.Training;

import java.util.List;

public interface TrainingRepository {
    String addTraining(Training training);
    void removeTraining(Training training);

    List<Training> getAllTrainings();
}
