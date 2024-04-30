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

    @Override
    public void basicAttack(characters defender) {
        int damage = rollers.damageRoll(11, 5);
        if(damage == 0){
            // implement logic for miss

        }//System.out.println(damage);
        defender.setHealth(defender.getHealth() - damage);
        //System.out.println(defender.getHealth());

    }

    @Override
    public void fireBall(characters defender) {
        int damage = rollers.damageRoll(26, 10);
        if(damage == 0){
            // implement logic for miss

        }
        defender.setHealth(defender.getHealth() - damage);
        System.out.println(defender.getHealth());
    }

    @Override
    public void heal(characters defender) {
        int health = defender.getHealth();
        int heal = rollers.healRoll(11 , 21 , defender, 8);
        if(health + heal > defender.getMaxHealth()){
            defender.setHealth(defender.getMaxHealth());
        } else {
            defender.setHealth(health + heal);
        }
        //print the health or if it failed(probably in the rollers instead because this doesnt return the status of failure)
    }

    @Override
    public void empower() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void flee() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
