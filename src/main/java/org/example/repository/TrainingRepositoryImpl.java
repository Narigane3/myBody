package org.example.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.mapper.TrainingMapper;
import org.example.model.Training;

import java.util.ArrayList;
import java.util.List;

public class TrainingRepositoryImpl implements TrainingRepository {
    public TrainingRepositoryImpl() {
    }

    @Override
    public String addTraining(Training training, String connectionString) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDb = mongoClient.getDatabase("my_body");
            MongoCollection<Document> collection = mongoDb.getCollection("trainings");
            collection.insertOne(TrainingMapper.trainingToDocument(training));
            return "Training added";
        } catch (Exception e) {
            System.out.println(e);
            return "Training not added";
        }
    }

    @Override
    public void removeTraining(Training training, String connectionString) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDb = mongoClient.getDatabase("my_body");
            MongoCollection<Document> collection = mongoDb.getCollection("trainings");
            collection.deleteOne(TrainingMapper.trainingToDocument(training));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Training> getAll(String connectionString) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDb = mongoClient.getDatabase("my_body");
            MongoCollection<Document> collection = mongoDb.getCollection("trainings");
            List<Training> trainings = new ArrayList<>();
            for (Document document : collection.find()) {
                trainings.add(TrainingMapper.documentToTraining(document));
            }
            return trainings;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
