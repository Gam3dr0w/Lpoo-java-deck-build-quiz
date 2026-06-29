import javax.swing.*;
import java.awt.*;

public class TelaFim extends JFrame {

    public TelaFim(boolean venceu, int pontuacaoFinal, String motivoExtra) {
        super("CodeArena: Deck do Conhecimento - Fim de Jogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 300);
        setMinimumSize(new Dimension(380, 260));
        setLocationRelativeTo(null);

        JPanel raiz = new JPanel();
        raiz.setLayout(new BoxLayout(raiz, BoxLayout.Y_AXIS));
        raiz.setBorder(BorderFactory.createEmptyBorder(28, 30, 28, 30));
        raiz.setBackground(Color.WHITE);

        JLabel icone = new JLabel(venceu ? "Vitoria!" : "Derrota");
        icone.setFont(new Font("SansSerif", Font.BOLD, 22));
        icone.setForeground(venceu ? new Color(40, 130, 90) : new Color(170, 60, 60));
        icone.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titulo = new JLabel(venceu
                ? "Parabens! Você venceu todas as batalhas!"
                : "Voce perdeu a jornada!");
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 6, 0));

        JLabel pontuacao = new JLabel("Pontuacao final: " + pontuacaoFinal);
        pontuacao.setFont(new Font("SansSerif", Font.BOLD, 15));
        pontuacao.setAlignmentX(Component.CENTER_ALIGNMENT);
        pontuacao.setBorder(BorderFactory.createEmptyBorder(0, 0, 24, 0));

        JButton botaoJogarNovamente = new JButton("Jogar novamente");
        TelaInicial.estilizarBotaoPrimario(botaoJogarNovamente);
        botaoJogarNovamente.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoJogarNovamente.setMaximumSize(new Dimension(220, 42));
        botaoJogarNovamente.addActionListener(e -> {
            new TelaInicial().setVisible(true);
            dispose();
        });

        JButton botaoSair = new JButton("Sair");
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setFont(new Font("SansSerif", Font.PLAIN, 13));
        botaoSair.setFocusPainted(false);
        botaoSair.setMaximumSize(new Dimension(220, 32));
        botaoSair.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        botaoSair.addActionListener(e -> System.exit(0));

        raiz.add(icone);
        raiz.add(titulo);
        raiz.add(pontuacao);
        raiz.add(botaoJogarNovamente);
        raiz.add(Box.createVerticalStrut(8));
        raiz.add(botaoSair);

        setContentPane(raiz);
    }
}
