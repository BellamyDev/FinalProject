/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myFinalProject;
import java.util.Random;

/**
 *
 * @author johnw
 */
public class rollers {
    public static int damageRoll(int max, int min){
        Random rand = new Random();
        int attackMax = max;
        int attackMin = min;
        int damage = rand.nextInt(attackMax - attackMin) + attackMin;
        int chance = rand.nextInt(100);
        if(chance < 20){
            return 0;
        }
        else{
            return damage;
        }

    }
    // this gives a random damage between the max and min values and have a 20 percent chance of not hitting
        public static int healRoll(int max, int min, characters healer, int cost){
        Random rand = new Random();
        int healMax = max;
        int healMin = min;
        int heal = rand.nextInt(healMax - healMin) + healMin;
        healer.setMana(healer.getMana() - cost);

            return heal;

    }
    

    
}
