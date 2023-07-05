package gui.users;

import gui.Window;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.repository.UserRepositoryImpl;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class UserGUI {

    public UserGUI(Window window, String connectionString) {
        this.window = window;
        window.getMasterContentWindow().removeAll();
        window.getMasterContentWindow().repaint();
        window.getMasterContentWindow().add(this.masterContent);
        window.getMasterContentWindow().revalidate();
        System.out.println("UserGui");

        UserRepository userRepository = new UserRepositoryImpl();
        User user = userRepository.getAll(connectionString).get(0);
        lastnameTextField.setText(user.getLastName());
        firstnameTextField.setText(user.getFirstName());
        String formattedBirthdate =
                new SimpleDateFormat("dd-MM-yyyy").format(user.getBirthDate());
        birthdateTextField.setText(formattedBirthdate);
        if (user.getGender()) {
            maleRadioButton.setSelected(true);
        } else {
            femaleRadioButton.setSelected(true);
        }

        saveButton.addActionListener(e -> {
            String lastname = lastnameTextField.getText();
            String firstname = firstnameTextField.getText();
            String birthdate = birthdateTextField.getText();
            Boolean gender = isFemaleRadioButtonSelected() || isMaleRadioButtonSelected();
            // change the user in the database
            user.setLastName(lastname);
            user.setFirstName(firstname);
            try {
                user.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse(birthdate));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            user.setGender(gender);
            userRepository.save(user, connectionString);
            new HomeGUI(window, connectionString);
        });
        backButton.addActionListener(e -> {
            new HomeGUI(window, connectionString);
        });
    }

    private final Window window;
    private JPanel masterContent;
    private JLabel titleLabel;
    private JLabel firstNameLabel;
    private JTextField lastnameTextField;
    private JTextField firstnameTextField;
    private JLabel firstnameLabel;
    private JLabel birthdateLabel;
    private JTextField birthdateTextField;
    private JLabel genderLabel;
    private JButton saveButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton backButton;

    public Window getWindow() {
        return window;
    }

    private Boolean isFemaleRadioButtonSelected() {
        return femaleRadioButton.isSelected();
    }

    private Boolean isMaleRadioButtonSelected() {
        return maleRadioButton.isSelected();
    }
}
