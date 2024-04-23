package myFinalProject;
import basicgraphics.BasicFrame;
import basicgraphics.ClockWorker;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JOptionPane;

public class graphics {
    final static Color OFF_WHITE = new Color(200,255,255);

    //Creates the characters
    public static Picture createCharacter(Color color) {
        Image im1 = BasicFrame.createImage(20, 20);
        Graphics imgr = im1.getGraphics();
        imgr.setColor(color);
        imgr.fillOval(0, 0, 20, 20);
        Picture p = new Picture(im1);
        p.transparentWhite();
        return p;
    }




    
}
