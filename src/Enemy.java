public class Enemy extends Character {
    public Enemy(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public void attack(Player player) {
        System.out.println(name + " atacou!");
        player.takeDamage(attack);
    }
}