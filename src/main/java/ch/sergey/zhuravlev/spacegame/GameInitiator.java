package ch.sergey.zhuravlev.spacegame;

import ch.sergey.zhuravlev.spacegame.entity.support.Grid;
import ch.sergey.zhuravlev.spacegame.gui.GamePanel;

import java.awt.*;

public final class GameInitiator {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public static void initGame(Application application) {
        GamePanel gamePanel = new GamePanel(0,0, 600, HEIGHT);
        Grid grid = new Grid(gamePanel.getWidth(), gamePanel.getHeight(), 10000, 10000, new Point(1000, 1000));
        gamePanel.getGameEntities().add(grid);
        application.getChild().add(gamePanel);
    }

}
