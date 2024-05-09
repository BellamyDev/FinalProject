package myFinalProject;

import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

class Foo implements ActionListener {//for mouse click debug

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Click!");
    }
}





public class gamePlayer extends Sprite{
    private static SpriteComponent batsc;
    private static SpriteComponent sticksc;
    private static SpriteComponent playerHealthsc;
    private static SpriteComponent oppHealthsc;
    private static SpriteComponent textsc;
    private static SpriteComponent fireballsc;
    public static TextSprite text;
    static final JButton attackButton = new JButton("Basic Attack");
    static final JButton healButton = new JButton("Heal");
    static final JButton fireballButton = new JButton("Fireball");
    static buttonLogic buttonLogic = new buttonLogic();
    public static HealthBarSprite playerHealth;
    public static HealthBarSprite oppHealth;
    private static textHandler textHandler = new textHandler();
    private static FireballSprite fireball;

    public static boolean printCoordinates = false;//for debug


    
    public gamePlayer(BasicFrame frame) {
        super(new SpriteComponent());
        batsc = new SpriteComponent();
        sticksc = new SpriteComponent();
        playerHealthsc = new SpriteComponent();
        oppHealthsc = new SpriteComponent();
        textsc = new SpriteComponent();
        fireballsc = new SpriteComponent();
        frame.add("topr", batsc);
        frame.add("row4r", attackButton);//attack button
        frame.add("row4l", fireballButton);//fireball button
        frame.add("row4m", healButton);//heal button
        frame.add("row3l", sticksc);
        frame.add("row2l", playerHealthsc);
        frame.add("row2r", oppHealthsc);
        frame.add("topm", textsc);
        frame.add("row3m", fireballsc);
        setupCoordinatePrinting();
    }
    private void setupCoordinatePrinting() {
        MouseListener coordinateListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (printCoordinates) {
                    System.out.println("Clicked at: " + e.getX() + ", " + e.getY());
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        };

        batsc.addMouseListener(coordinateListener);
        sticksc.addMouseListener(coordinateListener);
        playerHealthsc.addMouseListener(coordinateListener);
        oppHealthsc.addMouseListener(coordinateListener);
        textsc.addMouseListener(coordinateListener);
        fireballsc.addMouseListener(coordinateListener);
    }
    public static void initialize(){
        BasicFrame bf = startup.getBasicFrame();

        bat bat = new bat(batsc);
        player stickman = new player(sticksc);
        playerHealth = new HealthBarSprite(playerHealthsc, 100 , 400, 40 , 12);
        playerHealth.setY(200);
        oppHealth = new HealthBarSprite(oppHealthsc, 100, 400, 40 , 12);
        text = new TextSprite(textsc, "Welcome to the game", 15);
        text.setY(100);
        fireball = new FireballSprite(fireballsc, 22, 217, 564, 6);
        
        
                
        batsc.addSprite(bat);
        sticksc.addSprite(stickman);
        playerHealthsc.addSprite(playerHealth);
        oppHealthsc.addSprite(oppHealth);
        textsc.addSprite(text);
        fireballsc.addSprite(fireball);
        

        sticksc.repaint();
        batsc.repaint();
        playerHealthsc.repaint();
        oppHealthsc.repaint();
        textsc.repaint();
        bat.startIdleAnimation();
        stickman.startIdleAnimation();
        fireballsc.repaint();
        setupButtonActions();
        Player();
        

    }
    public static void setupButtonActions() {
        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerTurn) {
                    buttonLogic.buttonHeal(); 
                    playerTurn = false;
                    playerHealth.updateHealth(Game.player.getHealth());
                    oppHealth.updateHealth(Game.enemy.getHealth());
                }
            }
        });
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerTurn) {
                    buttonLogic.buttonAttack(); 
                    playerTurn = false; 
                    playerHealth.updateHealth(Game.player.getHealth());
                    oppHealth.updateHealth(Game.enemy.getHealth());
                    
                }
            }
        });
        fireballButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerTurn) {
                    buttonLogic.buttonFireball();
                    playerTurn = false; 
                    fireball.startAnimation();
                    playerHealth.updateHealth(Game.player.getHealth());
                    oppHealth.updateHealth(Game.enemy.getHealth());
                }
            }
        });

        enableButtons(false);
    }
    public static void enableButtons(boolean enable) {
        healButton.setEnabled(enable);
        attackButton.setEnabled(enable);
        fireballButton.setEnabled(enable);
        
    }
    static boolean playerTurn = true;
    

    public static void Player(){
        new Thread(() -> {
            while (Game.enemy.getHealth() > 0 && Game.player.getHealth() > 0) {
                if (playerTurn) {
                    SwingUtilities.invokeLater(() -> {
                        text.setText("Player's Turn");
                        enableButtons(true);
                    });
                    waitForPlayerAction();
    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
    
                } else {
                    SwingUtilities.invokeLater(() -> {
                        enableButtons(false);
                    });
                    Game.enemyAttack();
                    playerHealth.updateHealth(Game.player.getHealth());
                    oppHealth.updateHealth(Game.enemy.getHealth());                 
                    playerTurn = true;
    
                    
                    
                    try {
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            if (Game.enemy.getHealth() <= 0) {
                SwingUtilities.invokeLater(() -> {
                    textHandler.playerWin();
                    enableButtons(false);
                });
            } else {
                SwingUtilities.invokeLater(() -> {
                    textHandler.enemyWin();
                    enableButtons(false);
                });
            }
        }).start();

}
private static void waitForPlayerAction() {
    while (playerTurn) {
        try {
            Thread.sleep(100);  // Check every 100 ms if the player has taken an action
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
}




 