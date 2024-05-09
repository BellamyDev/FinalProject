package myFinalProject;

import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import java.awt.Dimension;

public class LoadingScreen extends Sprite {

    private BasicFrame frame;
    private SpriteComponent sc;
    private SpriteComponent loadingsc;
    private LoadingSprite ls;
    static String[][] layout = {
        {"topl", "topm", "topr"},
        {"row2l", "row2m", "row2r"},
        {"row3l", "row3m", "row3r"},
        {"row4l", "row4m", "row4r"}
    };
    

    public LoadingScreen(BasicFrame frame) {
        
        super(new SpriteComponent());
        this.frame = frame;
        this.sc = (SpriteComponent) this.getSpriteComponent();

        this.ls = new LoadingSprite(sc);
        loadingsc = new SpriteComponent();
        loadingsc.addSprite(ls);
        //sc.addSprite(ls);
        //sc.setPreferredSize(new Dimension(1080, 1920));
        frame.setStringLayout(layout);
        frame.add("topl", sc);
        //frame.add("topm", sc);
        //frame.add("row2l", sc);
        frame.add("row2m", loadingsc);
        //frame.add("row2r", sc);
       // frame.add("row3m", sc);
        frame.add("row3r", sc);
        gamePlayer gamePlayer = new gamePlayer(frame);
        //gamePlayer.initialize();
        
        
        
        frame.show();  
    }

    public void startAnimation() {
        // Start a new thread for the animation
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            long duration = 5000;  // Duration of the animation in milliseconds (5000 = 5 seconds). also change the duration in mainMenu.java
            while (System.currentTimeMillis() - startTime < duration) {
                try {
                    Thread.sleep(20);  // Update every 20 milliseconds/ less for faster animation
                    ls.move(new Dimension(loadingsc.getWidth(), loadingsc.getHeight()));  // Update the sprite's position/animation
                    loadingsc.repaint(); 
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return; 
                }
            }
            ls.finish();  
            sc.repaint();
            //gamePlayer.initialize();
            

        }).start();
    }

}
