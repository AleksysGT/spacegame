package ch.sergey.zhuravlev.spacegame.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class ParentComponent extends Component {

    public ParentComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.childs = new ArrayList<>();
    }

    private Collection<Component> childs;

    public void draw(Graphics2D graphics2D) {
        if (!visible) return;
        Shape saveClip = graphics2D.getClip();
        graphics2D.setClip(this);
        for (Component child : childs) {
            child.draw(graphics2D);
        }
        graphics2D.setClip(saveClip);
    }

    public void onClick(Point.Double relatedOnThisObject) {
        for (Component child : childs) {
            if (child.contains(relatedOnThisObject))
                child.onClick(new Point.Double(relatedOnThisObject.getX() - this.getX(),   relatedOnThisObject.getY() - this.getY()));
        }
    }

    public Collection<Component> getChilds() {
        return childs;
    }

}
