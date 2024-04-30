package myFinalProject;
import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import java.awt.Dimension;
public class startup {
    public static void start(){
        BasicFrame f = new BasicFrame("Game");
        SpriteComponent sc = new SpriteComponent();
        sc.setPreferredSize(new Dimension(400, 300));
        f.show();
    }


}