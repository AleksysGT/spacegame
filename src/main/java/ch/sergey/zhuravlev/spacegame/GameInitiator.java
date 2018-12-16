package ch.sergey.zhuravlev.spacegame;

import ch.sergey.zhuravlev.spacegame.entity.support.Grid;
import ch.sergey.zhuravlev.spacegame.gui.ColorPanel;
import ch.sergey.zhuravlev.spacegame.gui.GUI;
import ch.sergey.zhuravlev.spacegame.gui.GamePanel;
import ch.sergey.zhuravlev.spacegame.gui.Text;

import java.awt.*;

public final class GameInitiator {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public static void initGame(Application application) {
        GamePanel gamePanel = new GamePanel(0,0, 600, HEIGHT);
        Grid grid = new Grid(gamePanel.getWidth(), gamePanel.getHeight(), 10000, 10000, new Point(1000, 1000));
        gamePanel.getGameEntities().add(grid);
        application.getChild().add(gamePanel);

        GUI gui = new GUI();
        ColorPanel bottomPanel = new ColorPanel(0, 500, 800, 100, new Color(180,180,180));
        Text text = new Text(15, 515, "Fleets", gui.getFont(), Color.BLACK);
        gui.getChilds().add(bottomPanel);
        bottomPanel.getChilds().add(text);
        ColorPanel rightPanel = new ColorPanel(600, 0, 200, 600, new Color(180,180,180));
        gui.getChilds().add(rightPanel);
        application.getChild().add(gui);
    }

}
