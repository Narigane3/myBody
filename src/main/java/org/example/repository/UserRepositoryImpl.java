package org.example.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.example.mapper.UserMapper;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserRepositoryImpl implements UserRepository {
    UserMapper userMapper = new UserMapper();
    MongoCollection<Document> collection;

    public UserRepositoryImpl() {
    }

    @Override
    public String save(User user, String connectionString) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDb = mongoClient.getDatabase("my_body");
            MongoCollection<Document> collection = mongoDb.getCollection("users");
            // just update the user 0, which means the first user
            UpdateResult updateResult = collection.updateOne(new Document("user_id", 0), new Document("$set", userMapper.serToDocument(user)));
            if (updateResult.getModifiedCount() == 0) {
                InsertOneResult insertOneResult = collection.insertOne(userMapper.serToDocument(user));
                return Objects.requireNonNull(insertOneResult.getInsertedId()).toString();
            }
            return Objects.requireNonNull(updateResult.getUpsertedId()).toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<User> getAll(String connectionString) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDb = mongoClient.getDatabase("my_body");
            MongoCollection<Document> collection = mongoDb.getCollection("users");
            List<User> users = new ArrayList<>();
            for (Document document : collection.find()) {
                users.add(userMapper.documentToUser(document));
            }
            return users;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
