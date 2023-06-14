package gui;

import gui.users.UserGui;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    private GridBagLayout slaveGrid;

    private final Window window;

    public Home(Window window) {
        window.getMasterContentWindow().add(this.makeHome());
        this.window = window;
    }

    private JPanel makeHome() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Bienvenu sur l'application de gestion des entrainements MY BODY!");

        panel.add(label);

        JButton button = new JButton("Utilisateurs");

        GridBagConstraints slaveGrid = new GridBagConstraints();
        slaveGrid.gridy = 1;
        slaveGrid.gridx = 2;

        slaveGrid.fill = GridBagConstraints.HORIZONTAL;

        panel.add(button, slaveGrid);

        // Set event on click
        button.addActionListener(e -> {
            // Call the user panel
            UserGui userGui = new UserGui(window);
        });

        return panel;
    }

    public Window getWindow() {
        return window;
    }
}
