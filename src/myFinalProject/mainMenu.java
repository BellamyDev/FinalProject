package myFinalProject;
import basicgraphics.BasicFrame;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class mainMenu extends startup {
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
