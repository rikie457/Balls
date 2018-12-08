package nl.tychoengberink;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


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
        frame.setVisible(true);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        panel.initialize();
        Timer timer = new Timer(1000/60, e -> panel.repaint());
        timer.start();
    }
}
