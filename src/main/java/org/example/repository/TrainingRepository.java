package org.example.repository;

import org.example.model.Training;

import java.util.List;

public interface TrainingRepository {
    String addTraining(Training training, String connectionString);
    void removeTraining(Training training, String connectionString);

    List<Training> getAll(String connectionString);
}
