package edu.kit.iti.formal.mymachine.util;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Util {
    public static final ResourceBundle RESOURCE_BUNDLE =
            ResourceBundle.getBundle("edu.kit.iti.formal.mymachine.MyMachine");

    private static final Font FONT = new Font(Font.DIALOG, Font.BOLD, 20);
    private static final Icon FAIL_ICON = new Icon() {
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(Color.red);
            g.setFont(FONT);
            g.drawString("XXX", x+4, y+30);
        }

        @Override
        public int getIconWidth() {
            return 30;
        }

        @Override
        public int getIconHeight() {
            return 40;
        }
    };

    public static Icon imageResource(String filename) {
        URL url = ClassLoader.getSystemResource("img/" + filename);
        if(url == null) {
            return FAIL_ICON;
        } else {
            return new ImageIcon(url);
        }
    }

    public static Dimension getDimension(Icon icon) {
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }

    public static void drawCentered(Graphics2D g, Point pos, Icon icon) {
        icon.paintIcon(null, g, pos.x - icon.getIconWidth()/2, pos.y - icon.getIconHeight()/2);
    }

    public static String r(String s) {
        try {
            return RESOURCE_BUNDLE.getString(s);
        } catch (Exception ex) {
            ex.printStackTrace();
            return s;
        }
    }


}
