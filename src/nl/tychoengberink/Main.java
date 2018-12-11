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
        CanvasPanel panel = new CanvasPanel((int) width, (int) height);
        createObjects(frame, panel);

        Timer timer = new Timer(1000 / 240, e -> panel.repaint());
        timer.start();
    }

    private void createObjects(JFrame frame, CanvasPanel panel) {
        frame.setSize((int) width, (int) height);
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        panel.initialize();
    }
}
