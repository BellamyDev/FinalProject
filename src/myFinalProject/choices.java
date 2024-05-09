/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package myFinalProject;

/**
 *
 * @author johnw
 */
public interface choices {
    public void basicAttack(characters defender);
    public void fireBall(characters defender);
    public void heal(characters defender);
    public void flee(); // may become obsolete due to exit button
    
}
