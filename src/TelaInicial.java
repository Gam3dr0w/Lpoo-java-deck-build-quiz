import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

    private final JTextField campoNome = new JTextField();
    private final JRadioButton radioProgramador = new JRadioButton("Programador  (HP 100 / ATK 10 / DEF 3)", true);
    private final JRadioButton radioHacker = new JRadioButton("Hacker  (HP 85 / ATK 14 / DEF 1)");

    public TelaInicial() {
        super("CodeArena: Deck do Conhecimento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 360);
        setMinimumSize(new Dimension(420, 320));
        setLocationRelativeTo(null);

        JPanel raiz = new JPanel();
        raiz.setLayout(new BoxLayout(raiz, BoxLayout.Y_AXIS));
        raiz.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));
        raiz.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("CodeArena: Deck do Conhecimento");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitulo = new JLabel("Responda quiz para atacar, curar e defender em batalhas por turno.");
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtitulo.setForeground(new Color(90, 90, 90));
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitulo.setBorder(BorderFactory.createEmptyBorder(2, 0, 18, 0));

        JLabel rotuloNome = new JLabel("Nome do jogador");
        rotuloNome.setFont(new Font("SansSerif", Font.BOLD, 13));
        rotuloNome.setAlignmentX(Component.LEFT_ALIGNMENT);

        campoNome.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoNome.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        campoNome.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoNome.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));

        JLabel rotuloPersonagem = new JLabel("Escolha seu personagem");
        rotuloPersonagem.setFont(new Font("SansSerif", Font.BOLD, 13));
        rotuloPersonagem.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloPersonagem.setBorder(BorderFactory.createEmptyBorder(18, 0, 6, 0));

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioProgramador);
        grupo.add(radioHacker);
        for (JRadioButton r : new JRadioButton[]{radioProgramador, radioHacker}) {
            r.setAlignmentX(Component.LEFT_ALIGNMENT);
            r.setFont(new Font("SansSerif", Font.PLAIN, 13));
            r.setFocusPainted(false);
            r.setBackground(Color.WHITE);
        }

        JButton botaoIniciar = new JButton("Comecar jornada");
        estilizarBotaoPrimario(botaoIniciar);
        botaoIniciar.setAlignmentX(Component.LEFT_ALIGNMENT);
        botaoIniciar.addActionListener(this::aoClicarIniciar);

        JLabel dica = new JLabel("Voce enfrentara 3 inimigos em sequencia. Boa sorte!");
        dica.setFont(new Font("SansSerif", Font.ITALIC, 11));
        dica.setForeground(new Color(130, 130, 130));
        dica.setAlignmentX(Component.LEFT_ALIGNMENT);
        dica.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        raiz.add(titulo);
        raiz.add(subtitulo);
        raiz.add(rotuloNome);
        raiz.add(Box.createVerticalStrut(6));
        raiz.add(campoNome);
        raiz.add(rotuloPersonagem);
        raiz.add(radioProgramador);
        raiz.add(Box.createVerticalStrut(4));
        raiz.add(radioHacker);
        raiz.add(Box.createVerticalStrut(20));
        raiz.add(botaoIniciar);
        raiz.add(dica);

        setContentPane(raiz);

        campoNome.addActionListener(this::aoClicarIniciar);
    }

    private void aoClicarIniciar(ActionEvent e) {
        String nome = campoNome.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Digite um nome para o seu personagem.",
                    "Nome obrigatorio", JOptionPane.WARNING_MESSAGE);
            campoNome.requestFocus();
            return;
        }

        Character base = radioHacker.isSelected() ? new Hacker() : new Programmer();
        Player player = new Player(nome, base);

        new TelaBatalha(player).setVisible(true);
        dispose();
    }

    static void estilizarBotaoPrimario(JButton botao) {
        botao.setFont(new Font("SansSerif", Font.BOLD, 14));
        botao.setBackground(new Color(40, 110, 200));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        botao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
