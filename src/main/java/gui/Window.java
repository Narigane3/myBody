package gui;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    private final String window_title;

    private final JPanel masterContentWindow;

    public Window(String window_title) {
        super(window_title);

        this.window_title = window_title;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int height = dim.height / 2;
        int width = dim.width / 2;

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        this.masterContentWindow = panel;

        this.add(panel);

        this.setSize(width, height);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel getMasterContentWindow() {
        return masterContentWindow;
    }

    public String getWindow_title() {
        return window_title;
    }

}
