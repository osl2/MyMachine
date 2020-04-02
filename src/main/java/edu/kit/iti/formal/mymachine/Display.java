package edu.kit.iti.formal.mymachine;

import java.awt.*;

public class Display extends MachineElement {

    private static final Font FONT = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    private static final String NAME = "#Display";

    private String text = "";

    public Display() {
        super(NAME, new Dimension(200, 20));
    }
    @Override
    public void uiConfig() {
    }

    @Override
    public void paint(Graphics2D g, PaintMode neutral) {

        Point pos = getPosition();
        g.setColor(Color.black);
        g.fill3DRect(pos.x - 100, pos.y - 10, 200, 20, true);

        g.setColor(Color.white);
        g.setFont(FONT);
        g = (Graphics2D) g.create();
        g.setClip(pos.x - 100, pos.y - 10, 200, 20);
        g.drawString(text, pos.x - 90, pos.y + g.getFontMetrics().getAscent()/2);
    }

    @Override
    public void output(String out) {
        text = out;
    }
}
