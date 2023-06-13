package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.mapper.TrainingMapper;
import org.example.model.Training;

import java.util.ArrayList;
import java.util.List;

public class TrainingRepositoryImpl implements TrainingRepository {
    private MongoCollection<Document> collection;

    public TrainingRepositoryImpl(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    @Override
    public String addTraining(Training training) {
        Document document = TrainingMapper.trainingToDocument(training);
        collection.insertOne(document);
        return null;
    }

    @Override
    public void removeTraining(Training training) {
        Document document = TrainingMapper.trainingToDocument(training);
        collection.deleteOne(document);
    }

    @Override
    public List<Training> getAllTrainings() {
        List<Training> trainings = new ArrayList<>();
        List<Document> documents = collection.find().into(new ArrayList<>());
        for (Document document : documents) {
            Training training = TrainingMapper.documentToTraining(document);
            trainings.add(training);
        }
        return trainings;
    }
}
