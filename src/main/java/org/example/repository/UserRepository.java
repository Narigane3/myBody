package org.example.repository;

import org.example.model.User;

import java.util.List;

public interface UserRepository {
    /**
     * Save a user in the database
     * @param user instance of model User
     * @return
     */
    String save(User user);

    /**
     * Get all users from the database
     * @return list of users
     */
    List<User> getAll();

}
