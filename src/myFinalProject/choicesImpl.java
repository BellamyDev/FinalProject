/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myFinalProject;
/**
 *
 * @author johnw
 */

public class choicesImpl implements choices {
    static textHandler textHandler = new textHandler();

    @Override
    public void basicAttack(characters defender) {
        int damage = rollers.damageRoll(11, 5);
        if(damage == 0){
            textHandler.playerMiss();
            // implement logic for miss
        }//System.out.println(damage);

        if(damage > 0){
        defender.setHealth(defender.getHealth() - damage);
        //System.out.println(defender.getHealth());
        textHandler.basicAttack(damage);
        }

    }

    @Override
    public void fireBall(characters defender) {
        int damage = rollers.damageRoll(26, 10);
        if(Game.player.getMana() < 5){
            textHandler.notEnoughMana();
            return;
        }
        

        if(damage == 0){
            // implement logic for miss
            textHandler.playerMiss();


        }
        if(damage > 0){
        defender.setHealth(defender.getHealth() - damage);
        System.out.println(defender.getHealth());
        Game.player.setMana(Game.player.getMana() - 5);
        textHandler.fireBall(damage);
        }
    }

    @Override
    public void heal(characters defender) {
        if(defender.getMana() < 8){
            textHandler.notEnoughMana();
            return;
        }
        if(defender.getMana() >= 8){
        
        int health = defender.getHealth();
        int heal = rollers.healRoll(21 , 11 , defender, 8);
        if(health + heal > defender.getMaxHealth()){
            defender.setHealth(defender.getMaxHealth());
        } else {
            defender.setHealth(health + heal);//make output for the amount healed. probably put the code in the heal roll
        }
        textHandler.healed(defender, heal);
        

        //print the health or if it failed(probably in the rollers instead because this doesnt return the status of failure)
    }
    }


    @Override
    public void flee() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
