package org.example.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.example.mapper.UserMapper;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserRepositoryImpl implements UserRepository{
    UserMapper userMapper = new UserMapper();
    MongoCollection<Document> collection;
    public UserRepositoryImpl(MongoCollection<Document> usersCollection) {
        this.collection = usersCollection;
    }

    @Override
    public String save(User user) {
        InsertOneResult result = this.collection.insertOne(userMapper.UserToDocument(user));
        return Objects.requireNonNull(result.getInsertedId()).toString();
    }

    @Override
    public List<User> getAll() {
        List <User> users = new ArrayList<User>();
        for (Document document : this.collection.find()) {
            users.add(userMapper.documentToUser(document));
        }

        return null;
    }
}
