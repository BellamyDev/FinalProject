/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myFinalProject;

/**
 *
 * @author johnw
 */
public class Game extends choicesImpl {
    public static characters player = new characters("player");
    public static characters enemy = new characters("enemy");
    static textHandler textHandler = new textHandler();
    
        
        public static void main(String[] args) {
            run();
            // add menu, loading screen, setname maybe depending on the menu
        }
        public static void run(){
            startup.start();
            
        }
        public static void enemyAttack(){
            int damage = rollers.damageRoll(11, 5);
        if(damage == 0){
            textHandler.enemyMiss();// implement logic for miss

        }//System.out.println(damage);
        if(damage > 0){
        player.setHealth(player.getHealth() - damage);
        //System.out.println(defender.getHealth());
        textHandler.enemyHit(player, damage);

        }
    }
        

    
}
