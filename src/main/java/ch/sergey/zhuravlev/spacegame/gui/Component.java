package ch.sergey.zhuravlev.spacegame.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Component {

    private Collection<Component> childs;
    private boolean visible;
    private int x, y;

    public Component(int x, int y) {
        this(true, new ArrayList<Component>(), x, y);
    }

    public Component(boolean visible, Collection<Component> childs, int x, int y) {
        this.visible = visible;
        this.childs = childs;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics2D graphics2D);

    public abstract boolean isHandle(Point point);

    public void onClick(Point relatedOnThisObject) {
        for (Component child : childs) {
            if (child.isHandle(relatedOnThisObject))
                child.onClick(new Point((int) relatedOnThisObject.getX() - this.getX(),  (int) relatedOnThisObject.getY() - this.getY()));
        }
    }

    public Collection<Component> getChilds() {
        return childs;
    }

    public void setChilds(Collection<Component> childs) {
        this.childs = childs;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
