/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myFinalProject;

/**
 *
 * @author johnw
 */
// creates objects for the characters containing name, health, and mana
public class characters {
    //constructor for the characters
    String name;
    int health;
    int mana;

    public characters(String inputname){
        name = inputname;
        health = 100;
        mana = 50;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getMana(){
        return mana;
    }
    public void setHealth(int newHealth){
        health = newHealth;
    }
    public void setMana(int newMana){
        mana = newMana;
    }
    public void setName(String newName){
        name = newName;
    }
  

    
}
