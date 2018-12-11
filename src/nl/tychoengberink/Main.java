package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        JFrame frame = new JFrame();
        frame.setSize((int)width, (int)height);
        CanvasPanel panel = new CanvasPanel((int)width, (int)height);
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        panel.initialize();
        Timer timer = new Timer(1000 / 240, e -> panel.repaint());
        timer.start();
    }
}
