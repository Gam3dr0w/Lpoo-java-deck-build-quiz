import java.util.*;

public abstract class Question {
    protected String text, answer, category;

    public Question(String text, String answer, String category) {
        this.text = text;
        this.answer = answer;
        this.category = category;
    }

    public abstract boolean ask(Scanner sc);

    protected boolean check(String userAnswer) {
        return userAnswer.trim().equalsIgnoreCase(answer);
    }
}