public enum Difficulty {
    EASY("Facil", 0, 5),
    MEDIUM("Media", 3, 10),
    HARD("Dificil", 6, 15);

    private String name;
    private int damageBonus, score;

    Difficulty(String name, int damageBonus, int score) {
        this.name = name;
        this.damageBonus = damageBonus;
        this.score = score;
    }

    public String getName() { return name; }
    public int getDamageBonus() { return damageBonus; }
    public int getScore() { return score; }
}
