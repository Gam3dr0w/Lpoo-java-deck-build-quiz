import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("console")) {
            new Game().start();
            return;
        }

        SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}
