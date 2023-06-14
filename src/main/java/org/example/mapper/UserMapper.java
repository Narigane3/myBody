package org.example.mapper;

import org.example.model.User;
import org.bson.Document;

import java.util.Date;

public class UserMapper {

    /**
     * Convert User model to document
     *
     * @param user instance of model User
     * @return document of data user
     */
    public Document UserToDocument(User user) {
        return new Document()
                .append("user_id", user.getUser_id())
                .append("firstName", user.getFirstName())
                .append("lastName", user.getLastName())
                .append("birthDate", user.getBirthDate())
                .append("email", user.getEmail())
                .append("password", user.getPassword())
                .append("gender", user.getGender());
    }

    /**
     * Convert Document to User
     *
     * @param document document class rerun by the database
     * @return User instance
     */
    public User documentToUser(Document document) {
        return new User(
                (int) document.get("user_id"),
                (String) document.get("firstName"),
                (String) document.get("lastName"),
                (Date) document.get("birthDate"),
                (Boolean) document.get("gender"),
                (String) document.get("email"),
                (String) document.get("password")
        );
    }
}