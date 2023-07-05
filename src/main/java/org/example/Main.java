/**
 * My Body Main class
 * Author: Narigane
 * Date: 2021-06-13
 * Description: Main class for my body project to connect to mongodb atlas cluster
 * Version: 1.0
 */


package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import gui.Window;
import gui.users.HomeGUI;
import gui.users.UserGUI;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.cdimascio.dotenv.Dotenv;

import java.awt.*;


public class Main {
    private static final Dotenv dotenv = Dotenv.load();
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String connectionString = "mongodb+srv://" + dotenv.get("DB_USERNAME") + ":" + dotenv.get("DB_PASSWORD") + "@devdescktop.vpi0ffm.mongodb.net/";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Window window = new Window("My Body");
                new HomeGUI(window, connectionString);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}