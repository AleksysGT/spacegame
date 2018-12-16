package ch.sergey.zhuravlev.spacegame.entity;

import java.awt.*;

public abstract class GameEntity {

    private int gameX, gameY;
    private int gameHeight, gameWidth;

    public abstract void draw(Graphics2D graphics2D);

}
