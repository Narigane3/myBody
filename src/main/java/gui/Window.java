package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window () {
        super("Window");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame window = new Window();
    }
}
