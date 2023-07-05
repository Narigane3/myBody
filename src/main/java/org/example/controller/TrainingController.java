package org.example.controller;

import org.example.model.Training;

public interface TrainingController {
    String saveTraining(Training training, String connectionString);
}
