package myFinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class bat extends Sprite {

    private boolean movingUp = true; 

    public bat(SpriteComponent sc) {
        super(sc);
        setPicture(new Picture("bat.png"));
        //setX(400);
       setY(getY() + 40);
       // setVel(0, 0);
       //startIdleAnimation();
        
    }


    public void startIdleAnimation() {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            long duration = 1000000;  
            while (System.currentTimeMillis() - startTime < duration) {
                animateMovement();
                try {
                    Thread.sleep(200);  
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            finish();  
        }).start();
    }

   
    private void animateMovement() {
        java.awt.EventQueue.invokeLater(() -> {
            if (movingUp) {
                moveUp();
            } else {
                moveDown();
            }
            movingUp = !movingUp;
            getSpriteComponent().repaint();
        });

    }

    
    public void moveUp() {
        setY(getY() + 15);
    }

    public void moveDown() {
        setY(getY() - 15);
    }

    public void finish() {
        setVel(0, 0);  
}
}

