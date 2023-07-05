package gui.users;

import gui.Window;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.repository.UserRepositoryImpl;

import javax.swing.*;

public class HomeGUI {

    private JLabel firstnameLabel;
    private JPanel masterContent;
    private JButton accountButton;
    private JLabel lastnameLabel;
    private JList userData;
    private JButton createTrainingButton;
    private JButton trainingListButton;

    public HomeGUI(Window window, String connectionString) {
        window.getMasterContentWindow().removeAll();
        window.getMasterContentWindow().repaint();
        window.getMasterContentWindow().add(masterContent);
        window.getMasterContentWindow().revalidate();

        UserRepository userRepository = new UserRepositoryImpl();
        User user = userRepository.getAll(connectionString).get(0);
        lastnameLabel.setText(user.getLastName());
        firstnameLabel.setText(user.getFirstName());
        accountButton.addActionListener(e -> {
            new UserGUI(window, connectionString);
        });
        createTrainingButton.addActionListener(e -> {
            new CreateTrainingGUI(window, connectionString);
        });
        trainingListButton.addActionListener(e -> {
            new TrainingListGUI(window, connectionString);
        });
    }
}
