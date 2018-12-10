package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static final double WIDTH = 1920, HEIGHT = 1080;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        CanvasPanel panel = new CanvasPanel(WIDTH, HEIGHT);
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
