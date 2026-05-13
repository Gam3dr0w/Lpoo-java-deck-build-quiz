public class Player extends Character {
    private int score;

    public Player(String playerName, Character c) {
        super(playerName + " - " + c.getName(), c.getMaxHp(), c.getAttack(), c.getDefense());
    }

    public void addScore(int value) {
        score += value;
    }

    public int getScore() {
        return score;
    }
}