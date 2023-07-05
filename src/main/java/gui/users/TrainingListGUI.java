package gui.users;

import gui.Window;

import javax.swing.*;
import org.example.repository.TrainingRepository;
import org.example.repository.TrainingRepositoryImpl;
import org.example.model.Training;

public class TrainingListGUI {
    private JList<Object> trainingsList;
    private JPanel masterContent;

    public TrainingListGUI(Window window, String connectionString) {
        window.getMasterContentWindow().removeAll();
        window.getMasterContentWindow().repaint();
        window.getMasterContentWindow().add(this.masterContent);
        window.getMasterContentWindow().revalidate();

        TrainingRepository userRepository = new TrainingRepositoryImpl();
        DefaultListModel<Object> model = new DefaultListModel<>();
        for (Training training : userRepository.getAll(connectionString)) {
            model.addElement(training);
        }
        trainingsList.setModel(model);
    }
}
