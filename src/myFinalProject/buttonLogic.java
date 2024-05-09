package myFinalProject;

public class buttonLogic {
    static choicesImpl choices = new choicesImpl();
    public void buttonHeal(){
        choices.heal(Game.player);
        System.out.println(Game.player.getHealth() + " " + Game.enemy.getHealth());
    }
    public static void buttonAttack(){
        choices.basicAttack(Game.enemy);
        System.out.println(Game.player.getHealth() + " " + Game.enemy.getHealth());
    }
    public void buttonFireball(){
        choices.fireBall(Game.enemy);
        System.out.println(Game.player.getHealth() + " " + Game.enemy.getHealth());
    }
    public void buttonFlee(){
        choices.flee();
    }
    
}
