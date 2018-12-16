package ch.sergey.zhuravlev.spacegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.HashSet;

import ch.sergey.zhuravlev.spacegame.gui.Component;

public class Application extends JPanel implements Runnable, MouseListener {

    private Graphics2D graphics2D;
    private BufferedImage image;
    private Collection<Component> childs;

    private Thread thread;
    private boolean running;
    private int FPS = 30;
    private int targetTime = 1000 / FPS;

    public static void main(String[] args) {
        JFrame window = new JFrame("Space Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Application());
        window.pack();
        window.setVisible(true);
    }

    public Application() {
        super();
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        requestFocusInWindow();
        childs = new HashSet<Component>();
    }

    public void addNotify() {
        super.addNotify();
        if (thread == null){
            thread = new Thread(this);
            thread.start();
        }
        addMouseListener(this);
    }

    public void run() {
        init();

        long startTime;
        long urdTime;
        long waitTime;

        while(running) {
            startTime = System.nanoTime();

            render();
            draw();

            urdTime = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - urdTime;

            if (waitTime > 0)
            try {Thread.sleep(waitTime);} catch (Exception ignored) {}
        }
    }

    private void init() {
        GameInitiator.initGame(this);
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        graphics2D = (Graphics2D) image.getGraphics();
        running = true;
    }

    private void render() {
        for (Component child : childs) {
            child.draw(graphics2D);
        }
    }

    private void draw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    public void mouseClicked(MouseEvent e) {
        for (Component child : childs) {
            child.onClick(e.getPoint());
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public Collection<Component> getChild() {
        return childs;
    }
}
