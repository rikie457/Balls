package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;


public class Main {
    public static double width, height;
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Main.width = screenSize.getWidth();
        Main.height = screenSize.getHeight();
        CanvasPanel panel = new CanvasPanel((int) Main.width, (int) Main.height, 600);
        JFrame frame = new JFrame();
//        MouseAdapter mouse = new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//            }
//        };
//        frame.addMouseListener(mouse);
//        frame.addMouseMotionListener(mouse);
        frame.setSize((int) Main.width, (int) Main.height);
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        panel.initialize();
        Timer timer = new Timer(1000 / 120, e -> panel.repaint());
        timer.start();
    }
}
