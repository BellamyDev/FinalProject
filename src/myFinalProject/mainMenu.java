package myFinalProject;
import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import java.awt.Color;
import java.awt.Dimension;

public class mainMenu extends Sprite{
    public static int clickCheck = 0;//checks if game has been started

    public mainMenu(SpriteComponent sc) {
        super(sc);
    }

    public static void menu() {
        BasicFrame bf = startup.getBasicFrame();
        SpriteComponent sc = new SpriteComponent();
        sc.setPreferredSize(new Dimension(800, 600));
        sc.setBackground(Color.BLACK);
       //bf.createBasicLayout(sc);
        bf.addMenuAction("File", "Start Game", () -> {
            if(clickCheck == 0){

                startup.loadingScreen.startAnimation();
                new Thread(() -> {
                    try {
                        Thread.sleep(10000);  // wait for the duration of the loading animation / change if duration change
                        myFinalProject.Game.run();  // Start the game after loading is complete
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
                clickCheck = 1;
            }

            
        });
        bf.addMenuAction("File", "Exit", () -> System.exit(0));
        bf.show();

    }

}