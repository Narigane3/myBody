package org.example.mapper;

import org.bson.Document;
import org.example.model.Training;

public class TrainingMapper {
    public static Document trainingToDocument(Training training) {
        return new Document("name", training.getName())
                .append("duration", training.getDuration())
                .append("date", training.getDate())
                .append("postExerciseRecovery", training.getPostExerciseRecovery())
                .append("charge", training.getCharge());
    }

    public static Training documentToTraining(Document document) {
        return new Training(
                (String) document.get("name"),
                (String) document.get("duration"),
                (String) document.get("date"),
                (String) document.get("postExerciseRecovery"),
                (String) document.get("charge")
        );
    }
}
