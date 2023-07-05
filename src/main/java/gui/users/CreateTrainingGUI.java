package gui.users;

import gui.Window;

import javax.swing.*;
import org.example.repository.TrainingRepository;
import org.example.repository.TrainingRepositoryImpl;
import org.example.model.Training;

public class CreateTrainingGUI {
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel durationLabel;
    private JTextField durationTextField;
    private JPanel nameDurationPanel;
    private JPanel postExerciseRecoveryDatePanel;
    private JLabel postExerciseRecoveryLabel;
    private JTextField postExerciseRecoveryTextField;
    private JTextField dateTextField;
    private JLabel dateLabel;
    private JPanel buttonsPanel;
    private JButton backButton;
    private JButton saveButton;
    private JPanel masterContent;

    public CreateTrainingGUI(Window window, String connectionString) {
        window.getMasterContentWindow().removeAll();
        window.getMasterContentWindow().repaint();
        window.getMasterContentWindow().add(this.masterContent);
        window.getMasterContentWindow().revalidate();

        TrainingRepository trainingRepository = new TrainingRepositoryImpl();
        saveButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String duration = durationTextField.getText();
            String postExerciseRecovery = postExerciseRecoveryTextField.getText();
            String date = dateTextField.getText();
            String charge = String.valueOf(Integer.parseInt(duration) * Integer.parseInt(postExerciseRecovery));
            Training training = new Training(name, duration, postExerciseRecovery, date, charge);
            trainingRepository.addTraining(training, connectionString);
            new HomeGUI(window, connectionString);
        });
        backButton.addActionListener(e -> {
            new HomeGUI(window, connectionString);
        });
    }
}
