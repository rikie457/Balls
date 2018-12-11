package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    private double maxwidth;
    private double maxheight;
    private int amountOfShapes;
    public ArrayList<Shape> shapes = new ArrayList<>();
    private Info info = new Info();

    public CanvasPanel(double maxwidth, double maxheight) {
        this.maxwidth = maxwidth;
        this.maxheight = maxheight;
        this.amountOfShapes = 50;
    }

    public CanvasPanel(double maxwidth, double maxheight, int amountOfShapes) {
        this.maxwidth = maxwidth;
        this.maxheight = maxheight;
        this.amountOfShapes = amountOfShapes;
    }

    public void initialize() {
        double wh, mass;
        super.setBackground(Color.black);
        for (int i = 0; i < amountOfShapes; i++) {
            wh = (Math.random() * 25) + 10;
            mass = ((wh / 2) * (wh / 2)) * Math.PI;
            if (i % 2 == 0) {
                shapes.add(new Ball((Math.random() * this.maxwidth), (Math.random() * this.maxheight), wh, wh, new Color((int) (Math.random() * 0x1000000)), this.maxwidth, this.maxheight, (Math.random() * 2), (Math.random() * 2), mass));
            }else{
                shapes.add(new Square((Math.random() * this.maxwidth), (Math.random() * this.maxheight), wh, wh, new Color((int) (Math.random() * 0x1000000)), this.maxwidth, this.maxheight, (Math.random() * 2), (Math.random() * 2), mass));
            }
        }

    }


    public void paint(Graphics g) {
        super.paint(g);
        info.draw(g);
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g);

            for (int j = 0; j < shapes.size(); j++) {
               Physics.checkCollision(shapes.get(i), shapes);
            }

        }


    }
}