package myFinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LoadingSprite extends Sprite {
    private int angle = 0;

    public LoadingSprite(SpriteComponent sc) {
        super(sc);
        setPicture(createLoadingPicture());
        setVel(0, 0);  // Static position
        setX(340);
        setY(230);
    }

    private Picture createLoadingPicture() {
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.setColor(Color.white);
        g.fillArc(20, 20, 60, 60, 0, 270);  // Draw a semi circular arc
        g.dispose();
        return new Picture(img);
    }
    public void move(Dimension d) {
        angle += 10;
        if (angle >= 360) {
            angle = 0;
        }
        BufferedImage img = (BufferedImage) getPicture().getImage();
        Graphics g = img.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.setColor(Color.BLUE);
        g.fillArc(20, 20, 60, 60, angle, 270);  // Update the arc to simulate rotation
        g.dispose();
        setPicture(new Picture(img));  // Update the picture
    }
    public void finish() {
        BufferedImage img = (BufferedImage) getPicture().getImage();
        Graphics g = img.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.setColor(Color.white);
        g.fillArc(20, 20, 60, 60, angle, 270);
        setPicture(new Picture(img));

    }

}
