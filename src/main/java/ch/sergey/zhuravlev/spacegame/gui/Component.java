package ch.sergey.zhuravlev.spacegame.gui;

import java.awt.*;

public abstract class Component extends Rectangle {

    boolean visible;

    public Component(int x, int y, int width, int height) {
        this(true, x, y, width, height);
    }

    public Component(boolean visible,int x, int y, int width, int height) {
        this.visible = visible;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void draw(Graphics2D graphics2D) {
    }

    public void onClick(Point.Double relatedOnThisObject) {
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
