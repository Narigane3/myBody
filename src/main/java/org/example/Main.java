package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.cdimascio.dotenv.Dotenv;


public class Main {
    private static final Dotenv dotenv = Dotenv.load();
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    // login url for mongodb atlas cluster get from env variable
    private static final String connectionString = "mongodb+srv://" + dotenv.get("DB_PASSWORD") + ":" + dotenv.get("DB_USERNAME") + "@devdescktop.vpi0ffm.mongodb.net/";

    public static void main(String[] args) {

        logger.info("Welcome to my Body");

        logger.info(connectionString);

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            logger.info("Database connection successful");
        } catch (Exception e) {
            logger.error("An error occurred during connection ==> {}", e);
        }

    }
}