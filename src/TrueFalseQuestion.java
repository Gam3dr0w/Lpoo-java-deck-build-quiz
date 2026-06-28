import java.util.*;

public class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String answer, Difficulty difficulty) {
        super(text, answer, difficulty);
    }

    public boolean ask(Scanner sc) {
        System.out.println("\n[" + difficulty.getName() + "] " + text);
        System.out.print("V ou F: ");
        return check(sc.nextLine());
    }

    @Override
    public String getKind() { return "Verdadeiro ou Falso"; }
}
