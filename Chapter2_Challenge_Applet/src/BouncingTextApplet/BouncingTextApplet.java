package BouncingTextApplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {

    private Thread thread;
    private int x = 0;
    private final String text = "Getahun Ayalew"; // my name
    private boolean running = false;

    @Override
    public void init() {
        setSize(500, 200);
        setBackground(Color.BLACK);
    }

    
    public void start() {
        if (thread == null) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        running = false;
        thread = null;
    }

    
    public void run() {
        while (running) {
            x += 10;
            if (x > getWidth()) {
                x = 0;
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(text, x, 100);
    }
}
