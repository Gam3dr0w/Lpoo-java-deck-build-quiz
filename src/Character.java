public abstract class Character {
    protected String name;
    protected int hp, maxHp, attack, defense;

    public Character(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public void takeDamage(int damage) {
        int finalDamage = Math.max(1, damage - defense);
        hp -= finalDamage;
        if (hp < 0) hp = 0;
        System.out.println(name + " recebeu " + finalDamage + " de dano.");
    }

    public void heal(int value) {
        hp += value;
        if (hp > maxHp) hp = maxHp;
        System.out.println(name + " recuperou " + value + " de vida.");
    }

    public void buffAttack(int value) {
        attack += value;
        System.out.println(name + " ganhou +" + value + " de ataque.");
    }

    public void buffDefense(int value) {
        defense += value;
        System.out.println(name + " ganhou +" + value + " de defesa.");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
}