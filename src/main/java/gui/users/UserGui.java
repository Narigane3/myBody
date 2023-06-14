package gui.users;

import gui.Window;

import javax.swing.*;

public class UserGui{

    public UserGui(Window window) {
        this.window = window;
        window.getMasterContentWindow().removeAll();
        window.getMasterContentWindow().repaint();
        window.getMasterContentWindow().add(this.masterContent);
        window.getMasterContentWindow().revalidate();
        System.out.println("UserGui");
    }

    private final Window window;
    private JPanel masterContent;
    private JLabel titleLabel;
    private JLabel firstNameLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel lastNameLabel;

    public Window getWindow() {
        return window;
    }
}
