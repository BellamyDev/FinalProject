package myFinalProject;

public class textHandler {
    public void healed(characters player, int addedHealth){
        String text = "You healed for " + addedHealth + " health. You have " + player.getHealth() + " health and " + player.getMana() + " mana left.";
        gamePlayer.text.setText(text);
        
    }
    public void playerWin(){
        String text = "You have defeated the enemy!";
        gamePlayer.text.setText(text);
    }
    public void enemyWin(){
        String text = "You have been defeated by the enemy!";
        gamePlayer.text.setText(text);
    }
    public void enemyMiss(){
        String text = "The enemy missed!";
        gamePlayer.text.setText(text);
    }
    public void enemyHit(characters player, int damage){
        String text = "The enemy hit you for " + damage + " damage. You have " + player.getHealth() + " health left.";
        gamePlayer.text.setText(text);
    }
    public void playerMiss(){
        String text = "Your move missed!";
        gamePlayer.text.setText(text);
    }
    public void basicAttack(int damage){
        String text = "You used a basic attack and hit for " + damage + " damage!";
        gamePlayer.text.setText(text);
    }
    public void fireBall(int damage){
        String text = "You used a fireball and hit for " + damage + " damage! You have " + Game.player.getMana() + " mana left.";
        gamePlayer.text.setText(text);
    }
    public void notEnoughMana(){
        String text = "You do not have enough mana! You action was ineffective.";
        gamePlayer.text.setText(text);
    }

    
}
