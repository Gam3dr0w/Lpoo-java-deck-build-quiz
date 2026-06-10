public class Card implements SpecialAbility {
    private String id, name, desc;

    public Card(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public void use(Player p, Enemy e, Question q) {
        int bonus = q.getDifficulty().getDamageBonus();

        switch (id) {
            case "JAVA": e.takeDamage(p.getAttack() + 4 + bonus); break;
            case "LOOP": e.takeDamage((p.getAttack() * 2) + bonus); break;
            case "CURA": p.heal(p.getMaxHp() / 4 + p.getDefense() + bonus); break;
            case "ESCUDO": p.addTemporaryShield(3, 2); break;
            case "BUFF": p.buffAttack(3 + bonus / 2); break;
            case "HISTORIA": e.takeDamage(p.getAttack() + p.getDefense() + bonus); break;
            case "VIDA": p.heal(10 + bonus); break;
            case "CONTRA": p.buffDefense(1); e.takeDamage(p.getAttack() + p.getDefense() / 2 + bonus); break;
            case "MATH": e.takeDamage(p.getAttack() + 8 + bonus); break;
            case "FIREWALL": p.addTemporaryShield(3, 2); p.heal(4 + bonus); break;
        }
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String toString() { return name + " - " + desc; }
}
