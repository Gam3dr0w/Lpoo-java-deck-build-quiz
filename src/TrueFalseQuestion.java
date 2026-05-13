import java.util.*;

public class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String answer, String category) {
        super(text, answer, category);
    }

    public boolean ask(Scanner sc) {
        System.out.println("\n" + text);
        System.out.print("V ou F: ");
        return check(sc.nextLine());
    }
}