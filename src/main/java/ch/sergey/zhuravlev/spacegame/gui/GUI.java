package ch.sergey.zhuravlev.spacegame.gui;

import java.awt.*;

public class GUI extends ParentComponent {

    private Font font;

    public GUI() {
        super(0, 0, 800, 600);
        font = new Font("VCR OSD Mono", Font.PLAIN, 18);
    }

    public Font getFont() {
        return font;
    }
}
