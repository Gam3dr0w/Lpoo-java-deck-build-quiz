import java.util.*;

public class MultipleChoiceQuestion extends Question {
    private String[] options;

    public MultipleChoiceQuestion(String text, String answer, Difficulty difficulty, String... options) {
        super(text, answer, difficulty);
        this.options = options;
    }

    public boolean ask(Scanner sc) {
        System.out.println("\n[" + difficulty.getName() + "] " + text);
        for (int i = 0; i < options.length; i++) System.out.println((i + 1) + ") " + options[i]);
        System.out.print("Resposta: ");
        return check(sc.nextLine());
    }

    @Override
    public String[] getOptions() { return options; }

    @Override
    public String getKind() { return "Multipla Escolha"; }
}
