package org.example.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import com.mongodb.client.MongoClients;
import org.example.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectDB {

    private final String connectString;
    private MongoDatabase mongoDb;

    public ConnectDB() {
        Dotenv dotenv = Dotenv.load();
        Logger logger = LoggerFactory.getLogger(Main.class);
        MongoDatabase mongoDb = null;
        this.connectString = "mongodb+srv://" + dotenv.get("DB_USERNAME") + ":" + dotenv.get("DB_PASSWORD") + "@devdescktop.vpi0ffm.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(connectString)) {
            this.mongoDb = mongoClient.getDatabase("my_body");
            logger.info("Database connection successful");
        } catch (Exception e) {
            logger.error("An error occurred during connection ==> {}", e);
        }
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoDb.getCollection(collectionName);
    }
}
