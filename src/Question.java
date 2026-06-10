import java.util.*;

public abstract class Question {
    protected String text, answer;
    protected Difficulty difficulty;

    public Question(String text, String answer, Difficulty difficulty) {
        this.text = text;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public abstract boolean ask(Scanner sc);

    protected boolean check(String userAnswer) {
        return userAnswer.trim().equalsIgnoreCase(answer);
    }

    public Difficulty getDifficulty() { return difficulty; }
}
