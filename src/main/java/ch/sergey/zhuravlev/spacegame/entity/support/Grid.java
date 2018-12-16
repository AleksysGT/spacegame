package ch.sergey.zhuravlev.spacegame.entity.support;

import ch.sergey.zhuravlev.spacegame.entity.GameEntity;

import java.awt.*;

public class Grid extends GameEntity {

    // Размер сетки
    private int height;
    private int width;

    // Размер самой карты
    private int mapHeight;
    private int mapWidth;

    // Позиция относительно карты
    private Point mapPos;

    //Размер зума
    private int zoom = 1; // Один пункт занимет ** пикселей

    public Grid(int width, int height, int mapWidth, int mapHeight, Point mapPos) {
        this.width = width;
        this.height = height;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.mapPos = mapPos;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(new Color(50, 80, 90));

        for (int y = 100 - mapPos.y % 100; y <= height / zoom; y += 100) {// 100 - пунктов в 1 AE
            g.drawLine(0, y * zoom, width, y * zoom);
            g.drawString(String.valueOf(mapPos.y + y), 0, y * zoom);
        }
        for (int x = 100 - mapPos.x % 100; x <= width / zoom; x += 100) // 100 - пунктов в 1 AE
            g.drawLine(x * zoom, 0, x * zoom, height);

    }

    public Point getMapPos() {
        return mapPos;
    }

    public void setMapPos(Point mapPos) {
        this.mapPos = mapPos;
    }
}
