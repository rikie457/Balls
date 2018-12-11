package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;


public class Main {
    private double width, height;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.width = screenSize.getWidth();
        this.height = screenSize.getHeight();


        JFrame frame = new JFrame();
        CanvasPanel panel = new CanvasPanel(this.width, this.height, 25);
        createObjects(frame, panel);

        Timer timer = new Timer(1000 / 120, e -> panel.repaint());
        timer.start();
    }

    private void createObjects(JFrame frame, CanvasPanel panel) {
        frame.setSize((int) this.width, (int) this.height);
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.initialize();
    }
}
