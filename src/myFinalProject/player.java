package myFinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class player extends Sprite {
    private boolean movingFront = true;
    public player(SpriteComponent sc) {
        super(sc);
        setPicture(new Picture("stickman.png"));
        //setX(400);
       //setY(300);
       // setVel(0, 0);
        
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
        if (movingFront) {
            moveFront();
        } else {
            moveBack();
        }
        movingFront = !movingFront;  
    }

    
    public void moveFront() {
        setX(getX() + 15);
        getSpriteComponent().repaint();  
    }

    public void moveBack() {
        setX(getX() - 15);
        getSpriteComponent().repaint();  
    }

    public void finish() {
        setVel(0, 0);  
}


}
