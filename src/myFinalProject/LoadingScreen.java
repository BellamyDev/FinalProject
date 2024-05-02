package myFinalProject;

import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import java.awt.Dimension;

public class LoadingScreen extends Sprite {

    private BasicFrame frame;
    private SpriteComponent sc;
    private LoadingSprite ls;

    public LoadingScreen(BasicFrame frame) {
        
        super(new SpriteComponent());
        this.frame = frame;
        this.sc = (SpriteComponent) this.getSpriteComponent();

        this.ls = new LoadingSprite(sc);
        sc.addSprite(ls);
        sc.setPreferredSize(new Dimension(800, 600));

        
        frame.createBasicLayout(sc); 
        frame.show();  
    }

    public void startAnimation() {
        // Start a new thread for the animation
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            long duration = 5000;  // Duration of the animation in milliseconds (5000 = 5 seconds)
            while (System.currentTimeMillis() - startTime < duration) {
                try {
                    Thread.sleep(20);  // Update every 20 milliseconds/ less for faster animation
                    ls.move(new Dimension(sc.getWidth(), sc.getHeight()));  // Update the sprite's position/animation
                    sc.repaint(); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return; 
                }
            }
            ls.finish();  
            sc.repaint();

        }).start();
    }

}
