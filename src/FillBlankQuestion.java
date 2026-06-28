import java.util.*;

public class FillBlankQuestion extends Question {
    public FillBlankQuestion(String text, String answer, Difficulty difficulty) {
        super(text, answer, difficulty);
    }

    public boolean ask(Scanner sc) {
        System.out.println("\n[" + difficulty.getName() + "] Complete: " + text);
        System.out.print("Resposta: ");
        return check(sc.nextLine());
    }

    @Override
    public String getKind() { return "Complete a Lacuna"; }
}
