package ch.sergey.zhuravlev.spacegame.gui;

import java.awt.*;

public class Text extends Component {

    private String text;
    private Font font;
    private Color fontColor;

    public Text(int x, int y, String text, Font font, Color fontColor) {
        super(x, y, 0, 0);
        this.text = text;
        this.font = font;
        this.fontColor = fontColor;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Font saveFont = graphics2D.getFont();
        Color saveColor = graphics2D.getColor();

        this.setRect(x, y, width, height);

        graphics2D.setFont(font);
        graphics2D.setColor(fontColor);

        height = (int) font.getLineMetrics(text, graphics2D.getFontRenderContext()).getHeight();

        graphics2D.drawString(text, (int) this.getX(), (int) this.getY() + height);

        graphics2D.setFont(saveFont);
        graphics2D.setColor(saveColor);
    }

}
