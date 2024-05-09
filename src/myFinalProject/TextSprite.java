package myFinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;

public class TextSprite extends Sprite {
    public static String text;
    private Font font;
   

    public TextSprite(SpriteComponent sc, String text, int textSize) {
        super(sc);
        TextSprite.text = text;
        this.font = new Font("Arial", Font.BOLD, textSize);
        setPicture(createTextPicture());
    }

    private Picture createTextPicture() {
        BufferedImage tempImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics tempGraphics = tempImg.getGraphics();
        tempGraphics.setFont(font);
        FontMetrics fm = tempGraphics.getFontMetrics();
        int width = fm.stringWidth(text) + 20;
        int height = fm.getHeight() + 10;
        tempGraphics.dispose();

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(text, 10, fm.getAscent() + 5);
        g.dispose();
        return new Picture(img);
    }
    private final Object lock = new Object();

    public void setText(String newText) {
              new Thread(() -> {
        this.text = newText;
        setPicture(createTextPicture());
        
        SwingUtilities.invokeLater(() -> {
            getSpriteComponent().repaint();
        });

    }).start();
    }
}