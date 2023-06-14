package gui.users;

import gui.Window;
import org.example.mapper.UserMapper;
import org.example.model.ConnectDB;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.repository.UserRepositoryImpl;

import javax.swing.*;
import java.lang.reflect.Array;

public class HomeGUI {

    private JLabel nameLabel;
    private JPanel masterContent;

    public HomeGUI(Window window) {
        window.getMasterContentWindow().removeAll();
        window.getMasterContentWindow().repaint();
        window.getMasterContentWindow().add(masterContent);
        window.getMasterContentWindow().revalidate();

        // get users
        UserRepository userRepository = new UserRepositoryImpl(new ConnectDB().getCollection("users"));
        nameLabel.setText(userRepository.getAll().get(0).getFirstName());
        System.out.println("HomeGUI");
    }
}
