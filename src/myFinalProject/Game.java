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
        
        public static void main(String[] args) {
            run();
            // add menu, loading screen, setname maybe depending on the menu
        }
        public static void run(){
            characters player = new characters("player");
            characters enemy = new characters("enemy");
            choicesImpl choice = new choicesImpl();
            choice.basicAttack(enemy);
            choice.basicAttack(enemy);
            choice.basicAttack(enemy);
            choice.basicAttack(enemy);
            choice.basicAttack(enemy);
        }
        

    
}
