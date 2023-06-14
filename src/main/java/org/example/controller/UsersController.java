package org.example.controller;

import org.example.model.User;

public interface UsersController {
    void saveUser(User user);

    void loginUser(User user);

    void logoutUser(User user);

    void updateUser(User user);

}
