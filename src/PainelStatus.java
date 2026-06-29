import javax.swing.*;
import java.awt.*;

public class PainelStatus extends JPanel {

    private final JLabel rotuloNome = new JLabel();
    private final JLabel rotuloStats = new JLabel();
    private final JProgressBar barraHp = new JProgressBar(0, 100);

    private final Color corBarraCheia;

    public PainelStatus(Color corBarraCheia) {
        this.corBarraCheia = corBarraCheia;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)));

        rotuloNome.setFont(new Font("SansSerif", Font.BOLD, 14));
        rotuloNome.setAlignmentX(Component.LEFT_ALIGNMENT);

        barraHp.setStringPainted(true);
        barraHp.setAlignmentX(Component.LEFT_ALIGNMENT);
        barraHp.setMaximumSize(new Dimension(Integer.MAX_VALUE, 18));
        barraHp.setForeground(corBarraCheia);
        barraHp.setBorder(BorderFactory.createEmptyBorder());

        rotuloStats.setFont(new Font("SansSerif", Font.PLAIN, 12));
        rotuloStats.setForeground(new Color(90, 90, 90));
        rotuloStats.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloStats.setBorder(BorderFactory.createEmptyBorder(6, 0, 0, 0));

        add(rotuloNome);
        add(Box.createVerticalStrut(6));
        add(barraHp);
        add(rotuloStats);
    }

    public void atualizar(String nome, int hp, int maxHp, int ataque, int defesa) {
        rotuloNome.setText(nome);

        int hpSeguro = Math.max(0, hp);
        barraHp.setMaximum(Math.max(1, maxHp));
        barraHp.setValue(hpSeguro);
        barraHp.setString("HP " + hpSeguro + " / " + maxHp);

        double proporcao = maxHp == 0 ? 0 : (double) hpSeguro / maxHp;
        if (proporcao <= 0.25) {
            barraHp.setForeground(new Color(200, 50, 50));
        } else if (proporcao <= 0.5) {
            barraHp.setForeground(new Color(220, 150, 30));
        } else {
            barraHp.setForeground(corBarraCheia);
        }

        rotuloStats.setText("ATK " + ataque + "   |   DEF " + defesa);
    }
}
