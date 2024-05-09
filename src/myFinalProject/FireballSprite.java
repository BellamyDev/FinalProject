package myFinalProject;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FireballSprite extends Sprite {
    private final double startX;
    private final double startY;
    private final double endX;
    private final double endY;
    private boolean movingToEnd; //for animation state refrence and debugging
    private Thread animationThread;
    private final double speed = 12.0;

    public FireballSprite(SpriteComponent sc, double startX, double startY, double endX, double endY) {
        super(sc);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        init();
    }

    private void init() {
        setPicture(createFireballImage());
        setX(startX);
        setY(startY);
        setVel(0, 0);
        this.is_visible = false;  // Initially invisible to hide
    }

    private Picture createFireballImage() {
        int size = 20;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(0, 0, size, size);
        g.dispose();
        return new Picture(img);
    }

    

    public void startAnimation() {
        if (animationThread == null || !animationThread.isAlive()) {
            animationThread = new Thread(() -> {
                runAnimation();
            });
            animationThread.start();
        }
    }

    private void move() {
        setX(getX() + getVelX());
        setY(getY() + getVelY());
        getSpriteComponent().repaint(); 
    }

    private void runAnimation() {
        try {
            this.is_visible = true;  // Make the fireball visible
            while (!Thread.interrupted()) {
                double currx = getX();
                if (currx >= endX) {
                    setX(endX);
                    setY(endY);
                    break; 
                }
                moveTo(endX, endY, speed);
                move();
                Thread.sleep(16); 
                
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        done();
    }

    private void done() {
        this.is_visible = false;  // Hide the fireball
        setVel(0, 0); 
        setX(startX); 
        setY(startY);
        movingToEnd = false;
        move();
    }
    
}