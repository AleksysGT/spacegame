package ch.sergey.zhuravlev.spacegame.gui;

import ch.sergey.zhuravlev.spacegame.entity.GameEntity;
import java.awt.*;
import java.util.Collection;
import java.util.HashSet;

public class GamePanel extends Component {

    private int height, width;
    private Collection<GameEntity> gameEntities;

    public GamePanel(int x, int y, int width, int height) {
        super(x, y);
        this.height = height;
        this.width = width;
        gameEntities = new HashSet<GameEntity>();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(this.getX(), this.getY(), width, height);
        for (GameEntity gameEntity : gameEntities) {
            gameEntity.draw(graphics2D);
        }
    }

    public boolean isHandle(Point point) {
        return point.getX() > this.getX() && point.getX() < this.getX() + width &&
                point.getY() > this.getY() && point.getY() < this.getY() + height;
    }

    public Collection<GameEntity> getGameEntities() {
        return gameEntities;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
