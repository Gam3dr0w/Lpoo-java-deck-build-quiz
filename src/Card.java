public class Card {
    private String id, name, desc;

    public Card(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public void use(Player p, Enemy e) {
        switch (id) {
            case "JAVA":
                e.takeDamage(p.getAttack() + 12);
                break;
            case "LOOP":
                e.takeDamage(p.getAttack() * 2);
                break;
            case "CURA":
                p.heal(p.getMaxHp() / 4 + p.getDefense());
                break;
            case "ESCUDO":
                p.buffDefense(3);
                break;
            case "BUFF":
                p.buffAttack(3);
                break;
            case "HISTORIA":
                e.takeDamage(p.getAttack() + p.getDefense());
                break;
            case "VIDA":
                p.heal(10);
                break;
            case "CONTRA":
                p.buffDefense(1);
                e.takeDamage(p.getAttack() + p.getDefense() / 2);
                break;
            case "MATH":
                e.takeDamage(20);
                break;
            case "FIREWALL":
                p.buffDefense(5);
                p.heal(4);
                break;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " - " + desc;
    }
}