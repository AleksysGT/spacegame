package ch.sergey.zhuravlev.spacegame.gui;

import java.awt.*;

public class ColorPanel extends ParentComponent {

    private Color color;

    public ColorPanel(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.fill(this);
        super.draw(graphics2D);
    }

}
