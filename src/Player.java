public class Player extends Character {
    private int score, temporaryDefenseTurns;

    public Player(String playerName, Character c) {
        super(playerName + " - " + c.getName(), c.getMaxHp(), c.getAttack(), c.getDefense());
    }

    public void addTemporaryShield(int value, int turns) {
        buffDefense(value);
        temporaryDefenseTurns += turns;
        System.out.println("Escudo temporário ativo por " + turns + " turno(s).");
    }

    public void endTurn() {
        if (temporaryDefenseTurns > 0 && --temporaryDefenseTurns == 0) {
            defense = Math.max(0, defense - 3);
            System.out.println("O escudo temporário acabou.");
        }
    }

    public void addScore(int value) { score += value; }
    public int getScore() { return score; }
}
