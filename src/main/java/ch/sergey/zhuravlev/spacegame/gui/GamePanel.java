package ch.sergey.zhuravlev.spacegame.gui;

import ch.sergey.zhuravlev.spacegame.entity.GameEntity;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class GamePanel extends Component {

    private Collection<GameEntity> gameEntities;

    public GamePanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        gameEntities = new ArrayList<>();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fill(this);
        for (GameEntity gameEntity : gameEntities) {
            gameEntity.draw(graphics2D);
        }
    }

    public Collection<GameEntity> getGameEntities() {
        return gameEntities;
    }

}
