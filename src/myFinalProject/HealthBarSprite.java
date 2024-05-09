package myFinalProject;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HealthBarSprite extends Sprite {
    private int maxHealth;
    private int currentHealth;
    private int width;
    private int height;
    private int segments;

    public HealthBarSprite(SpriteComponent sc, int maxHealth, int width, int height, int segments) {
        super(sc);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.width = width;
        this.height = height;
        this.segments = segments;
        setPicture(createHealthBarPicture());
    }

    private Picture createHealthBarPicture() {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);  // Background color for the health bar
        g.setColor(Color.RED);
        g.fillRect(1, 1, width - 2, height - 2); // Initial health bar
        drawSegments(g);
        g.dispose();
        return new Picture(img);
    }

    private void drawSegments(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 1; i < segments; i++) {
            int x = i * width / segments;
            g.drawLine(x, 0, x, height);
        }
        g.drawRect(0, 0, width - 1, height - 1); 
    }

    public void updateHealth(int newHealth) {
        this.currentHealth = newHealth;
        Graphics g = getPicture().getImage().getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(1, 1, width - 2, height - 2); 
        g.setColor(Color.GREEN);
        int healthWidth = (int) ((width - 2) * ((double) currentHealth / maxHealth));
        g.fillRect(1, 1, healthWidth, height - 2); 
        drawSegments(g);
        g.dispose();
        getSpriteComponent().repaint();
    }
}
