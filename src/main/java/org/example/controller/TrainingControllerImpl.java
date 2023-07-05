package org.example.controller;

import org.example.model.Training;
import org.example.repository.TrainingRepository;

public class TrainingControllerImpl implements TrainingController {
    TrainingRepository trainingRepository;
    public TrainingControllerImpl(TrainingRepository trainingRepository){
        this.trainingRepository = trainingRepository;
    }
    @Override
    public String saveTraining(Training training, String connectionString) {
        return this.trainingRepository.addTraining(training, connectionString);
    }
}
